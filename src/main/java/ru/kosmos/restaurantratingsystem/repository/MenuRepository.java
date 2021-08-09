package ru.kosmos.restaurantratingsystem.repository;

import org.springframework.stereotype.Repository;
import ru.kosmos.restaurantratingsystem.model.Menu;

@Repository
public class MenuRepository {
    private final CrudMenuRepository repository;

    public MenuRepository(CrudMenuRepository repository) {
        this.repository = repository;
    }

    public Menu getMenuOnToday(Integer restaurantId) {
        return repository.getMenuOnToday(restaurantId);
    }

}
