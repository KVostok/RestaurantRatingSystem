package ru.kosmos.restaurantratingsystem.service;

import org.springframework.stereotype.Service;
import org.springframework.util.Assert;
import ru.kosmos.restaurantratingsystem.model.Menu;
import ru.kosmos.restaurantratingsystem.repository.MenuRepository;

import java.util.List;

import static ru.kosmos.restaurantratingsystem.util.validation.ValidationUtil.checkNotFoundWithId;

@Service
public class MenuService {
    private final MenuRepository menuRepository;

    public MenuService(MenuRepository menuRepository) {
        this.menuRepository = menuRepository;
    }

    public List<Menu> getAll() {
        return menuRepository.getAll();
    }

    public Menu get(int id) {
        return checkNotFoundWithId(menuRepository.get(id), id);
    }

    public void delete(int id) {
        checkNotFoundWithId(menuRepository.delete(id), id);
    }

    public Menu create(Menu menu) {
        Assert.notNull(menu, "Menu must not be null");
        return menuRepository.save(menu);
    }

    public Menu update(Menu menu) {
        Assert.notNull(menu, "Menu must not be null");
        return menuRepository.save(menu);
    }
}