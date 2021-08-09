package ru.kosmos.restaurantratingsystem.service;

import org.springframework.stereotype.Service;
import ru.kosmos.restaurantratingsystem.model.Restaurant;
import ru.kosmos.restaurantratingsystem.repository.MenuRepository;
import ru.kosmos.restaurantratingsystem.repository.RestaurantRepository;

import java.util.List;

@Service
public class RestaurantService {

    private final RestaurantRepository restaurantRepository;
    private final MenuRepository menuRepository;

    public RestaurantService(RestaurantRepository restaurantRepository, MenuRepository menuRepository) {
        this.restaurantRepository = restaurantRepository;
        this.menuRepository = menuRepository;
    }

    public List<Restaurant> getAll() {
        return restaurantRepository.getAll();
    }

}
