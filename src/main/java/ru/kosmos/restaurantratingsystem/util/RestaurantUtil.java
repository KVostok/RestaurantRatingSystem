package ru.kosmos.restaurantratingsystem.util;

import ru.kosmos.restaurantratingsystem.dto.RestaurantDTO;
import ru.kosmos.restaurantratingsystem.model.Restaurant;

import java.util.Collection;
import java.util.List;

public class RestaurantUtil {
    public static List<RestaurantDTO> getDTOs(Collection<Restaurant> restaurants) {
        return restaurants.stream()
        .map(restaurant -> createDTO(restaurant))
        .toList();
    }

    public static RestaurantDTO createDTO(Restaurant restaurant) {
        return new RestaurantDTO(restaurant.getId(), restaurant.getName(), restaurant.getMenues());
    }
}
