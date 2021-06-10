package ru.company.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import ru.company.service.WelcomeService;

import java.util.logging.Logger;

@RestController
public class WelcomeController {

    @Autowired
    WelcomeService welcomeService;

    private static final Logger logger = Logger.getLogger("WelcomeController.class");

    @GetMapping("/abc")
    public String getWelcome() {
        logger.info("...logging welcome message");
        String result = welcomeService.getWelcome();
        return result;
    }

    @RequestMapping(value = "/")
    public String redirectWelcome() {
        return "redirect:/welcome";
    }

    @GetMapping("/view/{name}")
    public ModelAndView view(@PathVariable("name") String name, Model model) {
        ModelAndView mav = new ModelAndView("index");
        model.addAttribute("msg", "Привет " + name);
        return mav;
    }

    @GetMapping("/raw")
    @ResponseBody
    public String raw() {
        return "Raw data";
    }

    @RequestMapping("/index")
    public ModelAndView getIndex() {
        return new ModelAndView("index");
    }
}
