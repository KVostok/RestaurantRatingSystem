package ru.kosmos.restaurantratingsystem.util;

import ru.kosmos.restaurantratingsystem.dto.MenuDTO;
import ru.kosmos.restaurantratingsystem.model.Menu;
import ru.kosmos.restaurantratingsystem.model.Restaurant;

import static ru.kosmos.restaurantratingsystem.util.DishesUtil.getSetOfEntity;

public class MenuUtil {

    public static Menu asEntity(MenuDTO menuDto) {
        Restaurant restaurant = new Restaurant();
        restaurant.setId(menuDto.getRestaurantId());
        return new Menu(restaurant, getSetOfEntity(menuDto.getDishes()));
    }

}
