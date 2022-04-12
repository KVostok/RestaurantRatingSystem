package ru.kosmos.restaurantratingsystem.web.controllers.menues;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import ru.kosmos.restaurantratingsystem.dto.DishesDTO;
import ru.kosmos.restaurantratingsystem.dto.MenuDTO;
import ru.kosmos.restaurantratingsystem.model.Menu;
import ru.kosmos.restaurantratingsystem.service.MenuService;
import ru.kosmos.restaurantratingsystem.util.MenuUtil;
import ru.kosmos.restaurantratingsystem.web.AbstractControllerTest;
import ru.kosmos.restaurantratingsystem.web.json.JsonUtil;

import java.time.LocalDate;
import java.util.List;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static ru.kosmos.restaurantratingsystem.testdata.MenuTestData.*;
import static ru.kosmos.restaurantratingsystem.testdata.RestaurantTestData.REST_ID;
import static ru.kosmos.restaurantratingsystem.testdata.UsersTestData.*;
import static ru.kosmos.restaurantratingsystem.util.exception.ErrorType.*;

class MenuRestControllerTest extends AbstractControllerTest {

    private static final String REST_URL = MenuRestController.REST_URL + '/';

    @Autowired
    private MenuService menuService;

    @Test
    void getWithDishes() throws Exception {
        perform(MockMvcRequestBuilders.get(REST_URL + MENU_ID)
                .with(userHttpBasic(admin)))
                .andExpect(status().isOk())
                .andDo(print())
                .andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
                .andExpect(WITH_DISHES_MATCHER.contentJson(menu));
    }

    @Test
    void getNotFound() throws Exception {
        perform(MockMvcRequestBuilders.get(REST_URL + NOT_FOUND)
                .with(userHttpBasic(admin)))
                .andDo(print())
                .andExpect(status().isUnprocessableEntity());
    }

    @Test
    void getAccessDenied() throws Exception {
        perform(MockMvcRequestBuilders.get(REST_URL + REST_ID)
                .with(userHttpBasic(user1)))
                .andExpect(status().isInternalServerError())
                .andExpect(errorType(APP_ERROR))
                .andExpect(detailMessage("Access is denied"))
                .andDo(print());
    }

    @Test
    void getUnAuth() throws Exception {
        perform(MockMvcRequestBuilders.get(REST_URL))
                .andExpect(status().isUnauthorized())
                .andDo(print());
    }

    @Test
    void createWithLocation() throws Exception {
        MenuDTO newDto = new MenuDTO(REST_ID + 5, List.of(new DishesDTO(10000, 10),
                new DishesDTO(10001, 20)));
        Menu newMenu = MenuUtil.asEntity(newDto);
        newMenu.setDate(LocalDate.now());
        ResultActions action = perform(MockMvcRequestBuilders.post(REST_URL)
                .contentType(MediaType.APPLICATION_JSON)
                .with(userHttpBasic(admin))
                .content(JsonUtil.writeValue(newDto)))
                .andDo(print())
                .andExpect(status().isCreated());

        Menu created = WITH_DISHES_MATCHER.readFromJson(action);
        int newId = created.id();
        newMenu.setId(newId);
        WITH_DISHES_MATCHER.assertMatch(created, newMenu);
        WITH_DISHES_MATCHER.assertMatch(menuService.getWithDishes(newId), newMenu);
    }

    @Test
    void createInvalid() throws Exception {
        MenuDTO invalid = new MenuDTO(null, null);
        perform(MockMvcRequestBuilders.post(REST_URL)
                .contentType(MediaType.APPLICATION_JSON)
                .content(JsonUtil.writeValue(invalid))
                .with(userHttpBasic(admin)))
                .andDo(print())
                .andExpect(status().isUnprocessableEntity())
                .andExpect(errorType(VALIDATION_ERROR));
    }

    @Test
    void createInvalidNoPrice() throws Exception {
        MenuDTO invalid = new MenuDTO(REST_ID + 5, List.of(new DishesDTO(10000, null),
                new DishesDTO(10001, null)));
        perform(MockMvcRequestBuilders.post(REST_URL)
                .contentType(MediaType.APPLICATION_JSON)
                .content(JsonUtil.writeValue(invalid))
                .with(userHttpBasic(admin)))
                .andDo(print())
                .andExpect(status().isConflict())
                .andExpect(errorType(DATA_ERROR));
    }

    @Test
    void createDuplicate() throws Exception {
        MenuDTO invalid = new MenuDTO(REST_ID, List.of(new DishesDTO(10000, 10),
                new DishesDTO(10001, 20)));
        perform(MockMvcRequestBuilders.post(REST_URL)
                .contentType(MediaType.APPLICATION_JSON)
                .content(JsonUtil.writeValue(invalid))
                .with(userHttpBasic(admin)))
                .andDo(print())
                .andExpect(status().isConflict())
                .andExpect(errorType(DATA_ERROR));
    }

}