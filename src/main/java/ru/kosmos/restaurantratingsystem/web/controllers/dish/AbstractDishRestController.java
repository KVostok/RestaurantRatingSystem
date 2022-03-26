package ru.kosmos.restaurantratingsystem.web.controllers.dish;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import ru.kosmos.restaurantratingsystem.model.Dish;
import ru.kosmos.restaurantratingsystem.service.DishService;

import java.util.List;

import static ru.kosmos.restaurantratingsystem.util.validation.ValidationUtil.assureIdConsistent;
import static ru.kosmos.restaurantratingsystem.util.validation.ValidationUtil.checkNew;

public abstract class AbstractDishRestController {

    private final Logger log = LoggerFactory.getLogger(getClass());

    @Autowired
    private DishService dishService;

    public Dish get(int id) {
        log.info("get dish {}", id);
        return dishService.get(id);
    }

    public void delete(int id) {
        log.info("delete dish {}", id);
        dishService.delete(id);
    }

    public Dish create(Dish dish) {
        log.info("create dish {}", dish);
        checkNew(dish);
        return dishService.create(dish);
    }

    public void update(Dish dish, int id) {
        log.info("update dish {} with id {}", dish, id);
        assureIdConsistent(dish, id);
        dishService.update(dish);
    }

    public List<Dish> getAll() {
        log.info("getAll dish");
        return dishService.getAll();
    }

}
