package ru.company.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import ru.company.service.DashboardService;

import static org.mockito.Mockito.mock;

@Configuration
public class BeanConfig {

    @Bean
    public DashboardService service() {
        return mock(DashboardService.class);
    }
}
