package ru.kosmos.restaurantratingsystem.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;
import ru.kosmos.restaurantratingsystem.model.Menu;
import ru.kosmos.restaurantratingsystem.repository.MenuRepository;

import java.time.LocalDate;

import static ru.kosmos.restaurantratingsystem.util.validation.ValidationUtil.checkNotFoundWithId;

@Service
public class MenuService {

    private final MenuRepository menuRepository;

    public MenuService(MenuRepository menuRepository) {
        this.menuRepository = menuRepository;
    }

    public Menu getWithDishes(int id) {
        return checkNotFoundWithId(menuRepository.getWithDishes(id), id);
    }

    public Menu get(int id) {
        return checkNotFoundWithId(menuRepository.get(id), id);
    }

    @Transactional
    public Menu create(Menu menu) {
        Assert.notNull(menu, "Menu must not be null");
        menu.setDate(LocalDate.now());
        return menuRepository.save(menu);
    }

}

