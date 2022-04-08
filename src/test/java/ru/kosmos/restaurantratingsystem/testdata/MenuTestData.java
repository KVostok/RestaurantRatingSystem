package ru.kosmos.restaurantratingsystem.testdata;

import ru.kosmos.restaurantratingsystem.MatcherFactory;
import ru.kosmos.restaurantratingsystem.model.Menu;
import ru.kosmos.restaurantratingsystem.model.Role;
import ru.kosmos.restaurantratingsystem.model.Users;

import java.time.LocalDate;
import java.util.List;

import static ru.kosmos.restaurantratingsystem.model.AbstractBaseEntity.START_SEQ;

public class MenuTestData {
    public static final MatcherFactory.Matcher<Menu> MATCHER = MatcherFactory.usingIgnoringFieldsComparator(Menu.class, "restaurant", "dishes", "votes");

    public static final int MENU_ID = START_SEQ;

    public static final Menu menu = new Menu(MENU_ID, LocalDate.now());
    public static final List<Menu> menues = List.of(menu, menu);
}
