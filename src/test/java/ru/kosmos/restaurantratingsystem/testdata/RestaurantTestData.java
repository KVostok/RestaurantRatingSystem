package ru.kosmos.restaurantratingsystem.testdata;

import ru.kosmos.restaurantratingsystem.MatcherFactory;
import ru.kosmos.restaurantratingsystem.dto.RestaurantDTO;
import ru.kosmos.restaurantratingsystem.model.Restaurant;

import static ru.kosmos.restaurantratingsystem.model.AbstractBaseEntity.START_SEQ;

public class RestaurantTestData {

    public static final MatcherFactory.Matcher<Restaurant> MATCHER = MatcherFactory.usingIgnoringFieldsComparator(Restaurant.class, "menues");
    public static MatcherFactory.Matcher<RestaurantDTO> DTO_MATCHER = MatcherFactory.usingEqualsComparator(RestaurantDTO.class);

    public static final int REST_ID = START_SEQ;

    public static final Restaurant rest1 = new Restaurant(REST_ID, "Радуга");

    public static Restaurant getNewRestaurant() {
        return new Restaurant(null, "NewRestaurant");
    }

    public static Restaurant getUpdatedRestaurant() {
        return new Restaurant(REST_ID, "UpdatedName");
    }

}
