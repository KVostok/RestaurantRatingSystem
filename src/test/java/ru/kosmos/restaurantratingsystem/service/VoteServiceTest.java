package ru.kosmos.restaurantratingsystem.service;

import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import ru.kosmos.restaurantratingsystem.model.Votes;

class VoteServiceTest extends AbstractServiceTest{
    private final Logger log = LoggerFactory.getLogger(getClass());

    @Autowired
    protected VoteService service;

    @Test
    void create() {
        Votes votes = service.create(10020, 10001);
        log.info("Create vote {}", votes);
    }
}