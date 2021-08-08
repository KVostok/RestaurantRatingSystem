package ru.kosmos.restaurantratingsystem.service;

import org.springframework.stereotype.Service;
import ru.kosmos.restaurantratingsystem.repository.RestaurantRepository;

@Service
public class RestaurantService {

    private final RestaurantRepository restaurantRepository;

    public RestaurantService(RestaurantRepository restaurantRepository) {
        this.restaurantRepository = restaurantRepository;
    }
}
