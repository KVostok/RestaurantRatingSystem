package ru.kosmos.restaurantratingsystem.testdata;

import ru.kosmos.restaurantratingsystem.MatcherFactory;
import ru.kosmos.restaurantratingsystem.model.Role;
import ru.kosmos.restaurantratingsystem.model.Roles;
import ru.kosmos.restaurantratingsystem.model.Users;
import ru.kosmos.restaurantratingsystem.web.json.JsonUtil;

import java.util.Set;

import static ru.kosmos.restaurantratingsystem.model.AbstractBaseEntity.START_SEQ;

public class UsersTestData {

    public static final MatcherFactory.Matcher<Users> MATCHER = MatcherFactory.usingIgnoringFieldsComparator(Users.class, "registered", "password", "votes");

    public static final int USER_ID = START_SEQ + 1;
    public static final int ADMIN_ID = START_SEQ;
    public static final int NOT_FOUND = 10;
    public static final int USER_ROLE_ID = START_SEQ + 1;
    public static final int ADMIN_ROLE_ID = START_SEQ;
    public static final int USER_ROLES_ID = START_SEQ + 2;
    public static final int ADMIN_ROLES_ID_1 = START_SEQ;
    public static final int ADMIN_ROLES_ID_2 = START_SEQ + 1;

    public static final Users user1 = new Users(USER_ID, "User1", "user1@yandex.ru", "password");
    public static final Users admin = new Users(ADMIN_ID, "Admin", "admin@gmail.com", "admin");
    public static final Role userRole = new Role(USER_ROLE_ID, "USER");
    public static final Role adminRole = new Role(ADMIN_ROLE_ID, "ADMIN");
    public static final Roles userRoles = new Roles(USER_ROLES_ID, user1, userRole);
    public static final Roles adminRoles1 = new Roles(ADMIN_ROLES_ID_1, admin, adminRole);
    public static final Roles adminRoles2 = new Roles(ADMIN_ROLES_ID_2, admin, userRole);

    static {
        user1.setRoles(Set.of(userRoles));
        admin.setRoles(Set.of(adminRoles1, adminRoles2));
    }
//
//    public static User getNew() {
//        return new User(null, "New", "new@gmail.com", "newPass", 1555, false, new Date(), Collections.singleton(Role.USER));
//    }
//
//    public static User getUpdated() {
//        return new User(USER_ID, "UpdatedName", "user@yandex.ru", "newPass", 330, false, new Date(), List.of(Role.ADMIN));
//    }

    public static String jsonWithPassword(Users users, String password) {
        return JsonUtil.writeAdditionProps(users, "password", password);
    }

}
