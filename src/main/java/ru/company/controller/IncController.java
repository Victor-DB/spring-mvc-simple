package ru.company.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import ru.company.service.IncService;
import ru.company.user.IncPojo;

import java.util.*;

@RestController
public class IncController {

    @Autowired
    IncService incService;

    @GetMapping("/inc")
    public ModelAndView getIncidentForm() {
        return new ModelAndView("inc");
    }

    @RequestMapping(value = "inc/list", method = RequestMethod.POST)
    public ModelMap getIncidents(
                                //Principal principal,
                                 String afterDate,
                                 @DateTimeFormat(pattern = "dd.MM.yyyy") Date onDate,
                                 @DateTimeFormat(pattern = "dd.MM.yyyy") Date onDateEnd,
                                 Integer maxCount,
                                 @RequestParam(value = "ord", defaultValue = "byLastUpdateDateDesc", required = false) String sortOrder,
                                 Long systemId, String incidentId, String filterType, String visibleType,
                                 @RequestParam(value = "systemIds", required = false) List<Long> systemIds) {
        String userDetails = "uid"; //principal

        if (systemIds == null && systemId != null) {
            systemIds = new ArrayList<>();
            systemIds.add(systemId);
        }

        ModelMap result = new ModelMap();
        result.put("result", "success");

        Collection<IncPojo> incidents = incService.getIncidents(afterDate, userDetails, sortOrder, systemIds, Collections.singletonList(incidentId), onDate, onDateEnd, filterType, visibleType);

        int count = incidents.size();

        if (maxCount != null && incidents.size() > maxCount) {
            incidents = new ArrayList<>(incidents).subList(0, maxCount);
        }
        result.put("incidents", incidents);
        result.put("incidentCount", count);
        return result;
    }
}
