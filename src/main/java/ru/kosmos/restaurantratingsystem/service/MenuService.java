package ru.kosmos.restaurantratingsystem.service;

import org.springframework.stereotype.Service;
import ru.kosmos.restaurantratingsystem.repository.MenuRepository;

@Service
public class MenuService {
    private final MenuRepository menuRepository;

    public MenuService(MenuRepository menuRepository) {
        this.menuRepository = menuRepository;
    }
}
