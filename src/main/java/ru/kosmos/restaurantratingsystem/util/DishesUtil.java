package ru.kosmos.restaurantratingsystem.util;

import ru.kosmos.restaurantratingsystem.dto.DishesDTO;
import ru.kosmos.restaurantratingsystem.model.Dish;
import ru.kosmos.restaurantratingsystem.model.Dishes;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class DishesUtil {

    public static Dishes asEntity(DishesDTO dishesDto) {
        Dish dish = new Dish();
        dish.setId(dishesDto.getDishId());
        return new Dishes(dish, dishesDto.getPrice());
    }

    public static Set<Dishes> getSetOfEntity(List<DishesDTO> listOfDto) {
        return listOfDto
                .stream()
                .map(DishesUtil::asEntity)
                .collect(Collectors.toSet());
    }

}
