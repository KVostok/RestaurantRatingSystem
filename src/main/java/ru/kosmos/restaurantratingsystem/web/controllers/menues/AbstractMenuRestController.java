package ru.kosmos.restaurantratingsystem.web.controllers.menues;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import ru.kosmos.restaurantratingsystem.model.Menu;
import ru.kosmos.restaurantratingsystem.service.MenuService;

import static ru.kosmos.restaurantratingsystem.util.validation.ValidationUtil.checkNew;

public abstract class AbstractMenuRestController {

    private final Logger log = LoggerFactory.getLogger(getClass());

    @Autowired
    private MenuService menuService;

    public Menu getWithDishes(int id) {
        log.info("get menu {}", id);
        return menuService.getWithDishes(id);
    }

    public Menu create(Menu menu) {
        log.info("create menu {}", menu);
        checkNew(menu);
        return menuService.create(menu);
    }

}
