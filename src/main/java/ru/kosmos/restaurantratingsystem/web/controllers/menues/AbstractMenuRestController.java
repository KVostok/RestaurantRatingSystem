package ru.kosmos.restaurantratingsystem.web.controllers.menues;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import ru.kosmos.restaurantratingsystem.dto.MenuDTO;
import ru.kosmos.restaurantratingsystem.model.Menu;
import ru.kosmos.restaurantratingsystem.service.MenuService;
import ru.kosmos.restaurantratingsystem.util.MenuUtil;

import java.util.List;

import static ru.kosmos.restaurantratingsystem.util.validation.ValidationUtil.assureIdConsistent;
import static ru.kosmos.restaurantratingsystem.util.validation.ValidationUtil.checkNew;

public abstract class AbstractMenuRestController {
    private final Logger log = LoggerFactory.getLogger(getClass());

    @Autowired
    private MenuService menuService;

    public Menu get(int id) {
        log.info("get menu {}" , id);
        return menuService.get(id);
    }

    public void delete(int id) {
        log.info("delete menu {}", id);
        menuService.delete(id);
    }

    public Menu create(Menu menu) {
        log.info("create menu {}", menu);
        checkNew(menu);
        return menuService.create(menu);
    }

    public void update(Menu menu, int id) {
        log.info("update menu {}", menu);
        assureIdConsistent(menu, id);
        menuService.update(menu);
    }

    public List<MenuDTO> getAll() {
        log.info("getAll");
        return MenuUtil.getDTOs(menuService.getAll());
    }
}
