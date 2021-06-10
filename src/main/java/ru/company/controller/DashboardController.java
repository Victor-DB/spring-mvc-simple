package ru.company.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;
import ru.company.service.DashboardService;

import java.util.Map;

@RestController
public class DashboardController {

    @Autowired
    DashboardService dashboardService;

    @PostMapping("/getIntegrationCalendarDayWidget")
    public ModelMap getIntegrationCalendarDayWidget() {
        ModelMap result = new ModelMap();
        result.put("result", "success");
        Map<String, Long> widgetModel = dashboardService.getIntegrationCalendarDayWidget();
        result.put("widget", widgetModel);
        return result;
    }


    @GetMapping("/dashboard")
    public ModelAndView getView() {
        return new ModelAndView("dashboard");
    }


}
