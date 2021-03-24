package test.one.service;

import test.one.entity.History;
import test.one.entity.ValCodeDaily;
import test.one.entity.ValRate;

import java.time.LocalDate;
import java.util.List;

public interface ServiceDAO {
    void saveOrUpdateValCodeDaily(ValCodeDaily v);

    void saveOrUpdateValRate(ValRate v);

    ValCodeDaily findValCodeDailyById(String id);

    List<ValCodeDaily> getValCodeDailys();

    boolean updateCodeDailyDB();

    boolean updateRateDB();

    List<String> getCharCodeList();

    double calculate(String from, String to, String need);

    public LocalDate getMaxDate();

    List<History> getHistoryList();

    public List<History> getHistoryAfterFilter(String code, String codeTwo, String date);
}
