package ru.kosmos.restaurantratingsystem.web.controllers.restaurants;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import ru.kosmos.restaurantratingsystem.dto.RestaurantDTO;
import ru.kosmos.restaurantratingsystem.model.Restaurant;
import ru.kosmos.restaurantratingsystem.service.RestaurantService;
import ru.kosmos.restaurantratingsystem.util.RestaurantUtil;

import java.util.List;

import static ru.kosmos.restaurantratingsystem.util.validation.ValidationUtil.assureIdConsistent;
import static ru.kosmos.restaurantratingsystem.util.validation.ValidationUtil.checkNew;

public abstract class AbstractRestaurantRestController {
    private final Logger log = LoggerFactory.getLogger(getClass());

    @Autowired
    private RestaurantService restaurantService;

    public Restaurant get(int id) {
        log.info("get restaurant {}" , id);
        return restaurantService.get(id);
    }

    public void delete(int id) {
        log.info("delete restaurant {}", id);
        restaurantService.delete(id);
    }

    public Restaurant create(Restaurant restaurant) {
        log.info("create {}", restaurant);
        checkNew(restaurant);
        return restaurantService.create(restaurant);
    }

    public void update(Restaurant restaurant, int id) {
        log.info("update {}", restaurant);
        assureIdConsistent(restaurant, id);
        restaurantService.update(restaurant);
    }

    public List<RestaurantDTO> getAllWithMenu() {
        log.info("getAllWithMenu");
        return RestaurantUtil.getDTOs(restaurantService.getAllWithMenu());
    }
}
