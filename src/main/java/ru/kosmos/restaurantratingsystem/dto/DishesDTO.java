package ru.kosmos.restaurantratingsystem.dto;

import java.beans.ConstructorProperties;
import java.util.Objects;

public class DishesDTO {

    private final Integer dishId;
    private final Integer price;

    @ConstructorProperties({"dishId", "price"})
    public DishesDTO(Integer dishId, Integer price) {
        this.dishId = dishId;
        this.price = price;
    }

    public Integer getDishId() {
        return dishId;
    }

    public Integer getPrice() {
        return price;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DishesDTO dishesDTO = (DishesDTO) o;
        return dishId.equals(dishesDTO.dishId) && price.equals(dishesDTO.price);
    }

    @Override
    public int hashCode() {
        return Objects.hash(dishId, price);
    }

    @Override
    public String toString() {
        return "DishesDTO{" +
                "dishId=" + dishId +
                ", price=" + price +
                '}';
    }

}
