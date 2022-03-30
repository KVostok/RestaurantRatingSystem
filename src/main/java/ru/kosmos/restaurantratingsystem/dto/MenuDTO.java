package ru.kosmos.restaurantratingsystem.dto;

import java.beans.ConstructorProperties;
import java.util.List;
import java.util.Objects;

public class MenuDTO {

    private final Integer restaurantId;
    private final List<DishesDTO> dishes;

    @ConstructorProperties({"restaurantId", "dishes"})
    public MenuDTO(Integer restaurantId, List<DishesDTO> dishes) {
        this.restaurantId = restaurantId;
        this.dishes = dishes;
    }

    public Integer getRestaurantId() {
        return restaurantId;
    }

    public List<DishesDTO> getDishes() {
        return dishes;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MenuDTO menuDTO = (MenuDTO) o;
        return restaurantId.equals(menuDTO.restaurantId) && dishes.equals(menuDTO.dishes);
    }

    @Override
    public int hashCode() {
        return Objects.hash(restaurantId, dishes);
    }

    @Override
    public String toString() {
        return "MenuDTO{" +
                "restaurantId=" + restaurantId +
                ", dishes=" + dishes +
                '}';
    }

}
