package test.one.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import test.one.entity.*;
import test.one.repository.HistoryRepository;
import test.one.repository.ValCodeDailyRepository;
import test.one.repository.ValRateRepository;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ServiceDAOImpl implements ServiceDAO {
    @Autowired
    private ValCodeDailyRepository valCodeDailyRepository;

    @Autowired
    private ValRateRepository valRateRepository;

    @Autowired
    private HistoryRepository historyRepository;

    RestTemplate restTemplate;

    public ServiceDAOImpl(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @Value("${cbr_calc.currency_catalog_url}")
    private String currency_catalog_url;
    @Value("${cbr_calc.daily_url}")
    private String daily_url;

    @Override
    public ValCodeDaily findValCodeDailyById(String id) {
        return valCodeDailyRepository.findById(id).get();
    }

    @Override
    public List<ValCodeDaily> getValCodeDailys() {
        return valCodeDailyRepository.findAll();
    }

    @Override
    public void saveOrUpdateValCodeDaily(ValCodeDaily v) {
        if (!v.getCode().isEmpty()) {
            valCodeDailyRepository.save(v);
        }
    }

    @Override
    public void saveOrUpdateValRate(ValRate v) {
        valRateRepository.save(v);
    }

    @Override
    public boolean updateCodeDailyDB() {
        ResponseEntity<ValCodeDailyRoot> response = restTemplate.exchange(
                currency_catalog_url,
                HttpMethod.GET,
                null,
                new ParameterizedTypeReference<>() {
                });

        if (response.hasBody()) {
            response.getBody().list.forEach(this::saveOrUpdateValCodeDaily);
        }
        return response.hasBody();
    }

    @Override
    public boolean updateRateDB() {
        ResponseEntity<ValRateRoot> response = restTemplate.exchange(
                daily_url,
                HttpMethod.GET,
                null,
                new ParameterizedTypeReference<>() {
                });

        if (response.hasBody()) {
            ValRateRoot valRateRoot = response.getBody();
            valRateRoot.prepareItems();
            valRateRoot.valutes.forEach(this::saveOrUpdateValRate);
        }
        return response.hasBody();
    }

    @Override
    public List<String> getCharCodeList(){
        List<ValCodeDaily> allById = valCodeDailyRepository.findAllById(valRateRepository.getCharCodeList());
        return allById.stream().map(ValCodeDaily::getCode).collect(Collectors.toList());
    }

    public double calculate(String from, String to, String need) {
        String valueFromStr = valRateRepository.getValueByValCodeId(valCodeDailyRepository.findIdByCode(from));
        String valueToStr = valRateRepository.getValueByValCodeId(valCodeDailyRepository.findIdByCode(to));
        double valueFrom = Double.parseDouble(valueFromStr.replace(",","."));
        double valueTo = Double.parseDouble(valueToStr.replace(",","."));
        double needValue = Double.parseDouble(need);
        double total = (valueFrom/valueTo) * needValue;

        History history = new History();
        history.setCode_from(from);
        history.setCode_to(to);
        history.setVal_from(needValue);
        history.setVal_to(total);
        history.setDate(valRateRepository.getMaxDate());

        historyRepository.save(history);
        return total;
    }

    public LocalDate getMaxDate() {
        return valRateRepository.getMaxDate();
    }

    @Override
    public List<History> getHistoryList() {
        return historyRepository.findAll();
    }

    public List<History> getHistoryAfterFilter(String code, String codeTwo, String date) {
        String[] s = date.split("-");
        int year = Integer.parseInt(s[0]);
        int month = Integer.parseInt(s[1]);
        int day = Integer.parseInt(s[2]);
        LocalDate needDate = LocalDate.of(year, month, day);

        return getHistoryList().stream()
                .filter(h -> h.getCode_from().equals(code))
                .filter(h -> h.getCode_to().equals(codeTwo))
                .filter(h -> h.getDate().equals(needDate))
                .collect(Collectors.toList());
    }
}
