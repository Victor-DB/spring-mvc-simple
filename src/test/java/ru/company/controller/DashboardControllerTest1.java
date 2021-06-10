package ru.company.controller;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;
import org.mockito.Spy;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import ru.company.config.BeanConfig;
import ru.company.config.WebAppConfig;
import ru.company.service.DashboardService;
import ru.company.service.WelcomeService;

import java.util.HashMap;
import java.util.Map;

import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@RunWith(MockitoJUnitRunner.class)  // SpringJUnit4ClassRunner.class
@ContextConfiguration(classes = {WebAppConfig.class, BeanConfig.class})
@WebAppConfiguration
public class DashboardControllerTest1 {

//    @Autowired
//    public WebApplicationContext wac;

    @InjectMocks
    private DashboardController dashboardController; //

    @Spy
    @InjectMocks
    public DashboardService dashboardService = new DashboardService();

    @Spy
    @InjectMocks
    WelcomeService  welcomeService = new WelcomeService();

    private MockMvc mvc;

    @Before
    public void init() {
        MockitoAnnotations.initMocks(this);
        mvc = MockMvcBuilders.standaloneSetup(dashboardController).build();
                //.webAppContextSetup(wac).build();
    }

    @Test
    public void shouldGetIntegrationCalendarDayWidget() throws Exception {
        Map<String, Long> result = new HashMap<>();
        result.put("Низкий", 2L);
        result.put("Средний", 3L);
        result.put("Высокий", 1L);
        result.put("Высокий+", 1L);
        result.put("Total", 7L);

        String expected = "{\"result\":\"success\",\"widget\":{\"Низкий\":2,\"Средний\":3,\"Total\":7,\"Высокий+\":1,\"Высокий\":1}}";

        doNothing().when(welcomeService).setName("low");
        //when(welcomeService1.setName("low")).then(); // если setName не void метод

        // when(dashboardService.getIntegrationCalendarDayWidget()).thenReturn(result); // если внутри getIntegrationCalendarDayWidget() нет void методов
        doReturn(result).when(dashboardService).getIntegrationCalendarDayWidget();

        MvcResult res = mvc.perform(post("/getIntegrationCalendarDayWidget")).andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.result").value("success"))
                .andExpect(jsonPath("$.widget.Низкий").value("2"))  // $.widget не String, a java.util.LinkedHashMap!!!
                .andExpect(jsonPath("$.widget.Total").value("7"))
                .andExpect(content().string(expected))
                .andReturn();
        System.out.println();
        System.out.println("content: " + res.getResponse().getContentAsString());
    }

}
