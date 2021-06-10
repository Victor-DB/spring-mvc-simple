package ru.company.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import ru.company.user.IncPojo;

import java.util.*;

@Component
public class IncService {

    public Collection<IncPojo> getIncidents(String afterDate,
                                            String userDetails,
                                            String sOrder,
                                            List<Long> systemIds,
                                            List<String> singletonList,
                                            Date onDate,
                                            Date onDateEnd,
                                            String filterType,
                                            String visibleType) {


        final Logger logger = LoggerFactory.getLogger(IncService.class);
        logger.info("afterDate: {}\n userDetails: {}\n sOrder: {}\n systemIds: {}\n singletonList: {}\n onDate: {}\n onDateEnd: {}\n filterType: {}\n visibleType: {}\n",afterDate, userDetails, sOrder, systemIds, singletonList, onDate, onDateEnd, filterType, visibleType);

        return Arrays.asList(
                new IncPojo("", "user", "", Arrays.asList(1L,2L,3L), Arrays.asList("", ""), new Date(), new Date(), "", ""),
                new IncPojo("", "user", "", Arrays.asList(1L,2L,3L), Arrays.asList("", ""), new Date(), new Date(), "", "")
        );

    }
}
