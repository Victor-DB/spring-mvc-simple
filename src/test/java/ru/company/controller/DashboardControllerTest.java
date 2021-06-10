package ru.company.controller;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;
import ru.company.config.WebAppConfig;
import ru.company.service.DashboardService;

import java.util.HashMap;
import java.util.Map;

import static org.hamcrest.Matchers.containsInAnyOrder;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {WebAppConfig.class})
@WebAppConfiguration
public class DashboardControllerTest {

    DashboardService ds = mock(DashboardService.class);

    @Autowired
    public WebApplicationContext wac;

    private MockMvc mvc;

    @Before
    public void init() {
        mvc = MockMvcBuilders.webAppContextSetup(wac).build();
    }

    @Test
    public void shouldGetIntegrationCalendarDayWidget() throws Exception {
        Map<String, Long> result = new HashMap<>();
        result.put("Низкий", 2L);
        result.put("Средний", 3L);
        result.put("Высокий", 1L);
        result.put("Высокий+", 1L);
        result.put("Total", 7L);

        Map<String, Object> map = new HashMap<>();
        map.put("result", "success");
        map.put("widget", result);

        String expected = "{\"result\":\"success\",\"widget\":{\"Низкий\":3,\"Средний\":3,\"Total\":8,\"Высокий+\":1,\"Высокий\":1}}";

        // {"result":"success","widget":{"Низкий":2,"Средний":3,"Total":7,"Высокий+":1,"Высокий":1}}

        when(ds.getIntegrationCalendarDayWidget()).thenReturn(result);
        mvc.perform(post("/getIntegrationCalendarDayWidget")).andDo(print())
                .andExpect(status().isOk())
//                .andExpect(jsonPath("$.result").value("success"))
//                .andExpect(jsonPath("$.widget").value("\"Низкий\":2,\"Средний\":3,\"Total\":7,\"Высокий+\":1,\"Высокий\":1"))
                .andExpect(content().string(expected));
    }

}
