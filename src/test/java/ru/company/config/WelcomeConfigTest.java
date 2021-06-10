package ru.company.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import ru.company.service.WelcomeService;

import static org.mockito.Mockito.mock;

@Configuration
@ComponentScan("ru.company")
public class WelcomeConfigTest {

//    @Bean
//    public WelcomeService welcomeService(){
//        return new WelcomeService();                // если надо тестировать
//    }

    @Bean
    public WelcomeService welcomeService(){
        return mock(WelcomeService.class);       // если не надо тестировать
    }

}
