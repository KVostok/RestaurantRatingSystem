package ru.kosmos.restaurantratingsystem.repository;

import org.springframework.stereotype.Repository;

@Repository
public class MenuRepository {
    private final CrudMenuRepository repository;

    public MenuRepository(CrudMenuRepository repository) {
        this.repository = repository;
    }

}
