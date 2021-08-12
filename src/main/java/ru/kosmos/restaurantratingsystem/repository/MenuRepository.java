package ru.kosmos.restaurantratingsystem.repository;

import org.springframework.stereotype.Repository;
import ru.kosmos.restaurantratingsystem.model.Menu;

import java.time.LocalDate;

@Repository
public class MenuRepository {
    private final CrudMenuRepository repository;

    public MenuRepository(CrudMenuRepository repository) {
        this.repository = repository;
    }

    public Menu getMenuOnToday(Integer restaurantId) {
        return repository.getMenuOnTodayByRestaurant(restaurantId, LocalDate.now());
    }

}
