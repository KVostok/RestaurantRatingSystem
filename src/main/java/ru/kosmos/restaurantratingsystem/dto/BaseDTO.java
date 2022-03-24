package ru.kosmos.restaurantratingsystem.dto;

import ru.kosmos.restaurantratingsystem.HasId;

public class BaseDTO implements HasId {

    protected Integer id;

    public BaseDTO(Integer id) {
        this.id = id;
    }

    @Override
    public Integer getId() {
        return id;
    }

    @Override
    public void setId(Integer id) {
        this.id = id;
    }
}
