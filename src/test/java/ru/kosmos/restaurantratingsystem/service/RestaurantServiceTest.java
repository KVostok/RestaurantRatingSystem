package ru.kosmos.restaurantratingsystem.service;

import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ActiveProfiles;
import ru.kosmos.restaurantratingsystem.model.Restaurant;

import java.util.List;

import static ru.kosmos.restaurantratingsystem.Profiles.DATAJPA;

@ActiveProfiles(DATAJPA)
class RestaurantServiceTest extends AbstractServiceTest{
    private final Logger log = LoggerFactory.getLogger(getClass());
    @Autowired
    protected RestaurantService service;

    @Test
    void getAllRestaurantWithMenuByDateIsNow() {
        List<Restaurant> all = service.getAllRestaurantWithMenuByDateIsNow();
        log.info("getAllRestaurantWithMenuByDateIsNow {}", all);
    }

}