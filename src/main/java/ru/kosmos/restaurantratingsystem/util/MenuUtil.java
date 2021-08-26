package ru.kosmos.restaurantratingsystem.util;

import ru.kosmos.restaurantratingsystem.dto.MenuDTO;
import ru.kosmos.restaurantratingsystem.model.Menu;

import java.util.Collection;
import java.util.List;

public class MenuUtil {
    public static List<MenuDTO> getDTOs(Collection<Menu> menues) {
        return menues.stream()
                .map(menu -> createDTO(menu))
                .toList();
    }

    public static MenuDTO createDTO(Menu menu) {
        return new MenuDTO(menu);
    }
}
