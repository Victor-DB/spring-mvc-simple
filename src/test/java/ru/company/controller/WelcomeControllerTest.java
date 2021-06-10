package ru.company.controller;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;
import ru.company.config.WebAppConfig;
import ru.company.service.WelcomeService;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@RunWith(SpringJUnit4ClassRunner.class)  //junit4         //@ExtendWith(SpringJUnit4ClassRunner.class)  junit5
@ContextConfiguration(classes = { WebAppConfig.class } )
//@ContextConfiguration(classes = WelcomeConfigTest.class, loader = AnnotationConfigContextLoader.class)   // для подключения своей тестовой конфигурации
@WebAppConfiguration
public class WelcomeControllerTest {

//---------------------------------------------
    @Mock
    private WelcomeService welcomeService;
    @InjectMocks
    private WelcomeController welcomeController;
//-----------------------------------------------

    @Autowired
    private WebApplicationContext wac;  // подргузит наш контроллер к которому будем обращаться
    private MockMvc mvc;            // объект, через который будем делать запросы к контроллеру

    @Before
    public void init() {                // mockMvc нужно проинициализировать
         mvc = MockMvcBuilders.webAppContextSetup(wac).build();
    }

    @Test
    public void testFunc(){
        String expected = "1";
        assertThat(expected, is("1"));
    }

//    @Test
//    public void shouldRedirectToWelcomePage() throws Exception {
//        mvc.perform(get("/")).andDo(print())
//                .andExpect(status().is3xxRedirection())
//                .andExpect(redirectedUrl("/welcome"));
//    }

    @Test
    public void getIndex() throws Exception {
        mvc.perform(get("/index")).andDo(print())
                .andExpect(status().isOk())
                .andExpect(view().name("index"));
    }

//    @Test
//    public void viewShouldReturnGreetingWithSpecificName() throws Exception {
//        String name = "stranger";
//        String expected = "Привет " + name;
//
//        mvc.perform(get("/view/{name}"))
//                .andExpect(status().isOk())
//                .andExpect(model().attribute("msg", expected))
//                .andExpect(view().name("/index"));
//    }

    @Test
    public void rawShouldReturnResponseBody() throws Exception {
        mvc.perform(get("/raw")).andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().contentTypeCompatibleWith(MediaType.TEXT_PLAIN))   // content - содержимое респонса /проверка что контент содержит текст
                .andExpect(content().string("Raw data"));                // проверка что в контенте есть строчка "Raw data"
    }

}
