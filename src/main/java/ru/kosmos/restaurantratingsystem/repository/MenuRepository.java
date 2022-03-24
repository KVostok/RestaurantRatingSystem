package ru.kosmos.restaurantratingsystem.repository;

import org.springframework.stereotype.Repository;
import ru.kosmos.restaurantratingsystem.model.Menu;

@Repository
public class MenuRepository {
    private final CrudMenuRepository repository;

    public MenuRepository(CrudMenuRepository repository) {
        this.repository = repository;
    }

    public Menu save(Menu menu) {
        return repository.save(menu);
    }

    public boolean delete(int id) {
        return repository.delete(id) != 0;
    }

    public Menu get(int id) {
        return repository.getWithDishes(id);
    }
}
