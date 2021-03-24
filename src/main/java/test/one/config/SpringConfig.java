package test.one.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.ui.Model;
import org.springframework.web.client.RestTemplate;
import test.one.entity.ValCodeDaily;
import test.one.service.ServiceDAO;

import javax.annotation.PostConstruct;
import java.util.List;

@Configuration
public class SpringConfig {
    @Autowired
    ServiceDAO service;

    @PostConstruct
    public void init() {
        List<ValCodeDaily> valCodeList = service.getValCodeDailys();
        if (valCodeList.isEmpty()) {
            service.updateCodeDailyDB();
            service.updateRateDB();
        }
    }

    @Bean("restTemplate")
    public RestTemplate getRestTemplate() {
        return new RestTemplate();
    }
}
