package ru.kosmos.restaurantratingsystem.service;

import org.springframework.stereotype.Service;
import org.springframework.util.Assert;
import ru.kosmos.restaurantratingsystem.model.Restaurant;
import ru.kosmos.restaurantratingsystem.repository.RestaurantRepository;

import java.util.List;

import static ru.kosmos.restaurantratingsystem.util.validation.ValidationUtil.checkNotFoundWithId;

@Service
public class RestaurantService {

    private final RestaurantRepository restaurantRepository;

    public RestaurantService(RestaurantRepository restaurantRepository) {
        this.restaurantRepository = restaurantRepository;
    }

    public List<Restaurant> getAllRestaurantWithMenuByDateIsNow() {
        return restaurantRepository.getAllRestaurantWithMenuWithDishesWithVotesByDateIsNow();
    }

    public List<Restaurant> getAllRestaurants() {
        return restaurantRepository.getAllRestaurants();
    }

    public Restaurant get(int id) {
        return checkNotFoundWithId(restaurantRepository.get(id), id);
    }

    public void delete(int id) {
        checkNotFoundWithId(restaurantRepository.delete(id), id);
    }

    public Restaurant create(Restaurant restaurant) {
        Assert.notNull(restaurant, "restaurant must not be null");
        return restaurantRepository.save(restaurant);
    }

    public Restaurant update(Restaurant restaurant) {
        Assert.notNull(restaurant, "restaurant must not be null");
        return restaurantRepository.save(restaurant);
    }
}
