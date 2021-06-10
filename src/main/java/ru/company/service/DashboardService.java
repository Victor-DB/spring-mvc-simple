package ru.company.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.*;

@Component
public class DashboardService {

    @Autowired
    WelcomeService welcomeService;

    private class Integration {
        private String risk;

        public Integration() {
        }

        public Integration(String risk) {
            this.risk = risk;
        }

        public String getRisk() {
            return risk;
        }

        public void setRisk(String risk) {
            this.risk = risk;
        }
    }


    public Map<String, Long> getIntegrationCalendarDayWidget() {
        List<Integration> integrationCalendarList = Arrays.asList(
                new Integration("Высокий"),
                new Integration("Высокий+"),
                new Integration("Низкий"),
                new Integration("Низкий"),
                new Integration("Низкий"),
                new Integration("Средний"),
                new Integration("Средний"),
                new Integration("Средний")
        );

        Map<String, Long> result = new HashMap<>();
        result.put("Низкий", 0L);
        result.put("Средний", 0L);
        result.put("Высокий", 0L);
        result.put("Высокий+", 0L);
        result.put("Total", new Long(integrationCalendarList.size()));

        welcomeService.setName("Низкий"); // имитация обращения к БД

        for (Integration source : integrationCalendarList) {
            String risk = source.getRisk();
            Long count = result.get(risk);
            if (count != null) {
                count++;
                result.put(risk, count);
            }
        }
        return result;
    }

}