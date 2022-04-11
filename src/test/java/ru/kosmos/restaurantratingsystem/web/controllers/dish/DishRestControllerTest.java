package ru.kosmos.restaurantratingsystem.web.controllers.dish;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import ru.kosmos.restaurantratingsystem.model.Dish;
import ru.kosmos.restaurantratingsystem.service.DishService;
import ru.kosmos.restaurantratingsystem.testdata.DishTestData;
import ru.kosmos.restaurantratingsystem.util.exception.NotFoundException;
import ru.kosmos.restaurantratingsystem.web.AbstractControllerTest;
import ru.kosmos.restaurantratingsystem.web.json.JsonUtil;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static ru.kosmos.restaurantratingsystem.testdata.DishTestData.MATCHER;
import static ru.kosmos.restaurantratingsystem.testdata.DishTestData.*;
import static ru.kosmos.restaurantratingsystem.testdata.UsersTestData.*;
import static ru.kosmos.restaurantratingsystem.util.exception.ErrorType.*;

class DishRestControllerTest extends AbstractControllerTest {

    private static final String REST_URL = DishRestController.REST_URL + '/';

    @Autowired
    private DishService dishService;

    @Test
    void get() throws Exception {
        perform(MockMvcRequestBuilders.get(REST_URL + DISH_ID)
                .with(userHttpBasic(admin)))
                .andExpect(status().isOk())
                .andDo(print())
                .andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
                .andExpect(MATCHER.contentJson(dish1));
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
        perform(MockMvcRequestBuilders.get(REST_URL + DISH_ID)
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
    void delete() throws Exception {
        perform(MockMvcRequestBuilders.delete(REST_URL + DISH_ID)
                .with(userHttpBasic(admin)))
                .andDo(print())
                .andExpect(status().isNoContent());
        assertThrows(NotFoundException.class, () -> dishService.get(DISH_ID));
    }

    @Test
    void deleteNotFound() throws Exception {
        perform(MockMvcRequestBuilders.delete(REST_URL + NOT_FOUND)
                .with(userHttpBasic(admin)))
                .andDo(print())
                .andExpect(status().isUnprocessableEntity());
    }

    @Test
    void update() throws Exception {
        Dish updated = DishTestData.getUpdated();
        perform(MockMvcRequestBuilders.put(REST_URL + DISH_ID)
                .contentType(MediaType.APPLICATION_JSON)
                .with(userHttpBasic(admin))
                .content(JsonUtil.writeValue(updated)))
                .andExpect(status().isNoContent());

        MATCHER.assertMatch(dishService.get(DISH_ID), updated);
    }

    @Test
    void updateHtmlUnsafe() throws Exception {
        Dish updated = new Dish(dish1);
        updated.setName("<script>alert(123)</script>");
        perform(MockMvcRequestBuilders.put(REST_URL + DISH_ID)
                .contentType(MediaType.APPLICATION_JSON)
                .with(userHttpBasic(admin))
                .content(JsonUtil.writeValue(updated)))
                .andDo(print())
                .andExpect(status().isUnprocessableEntity())
                .andExpect(errorType(VALIDATION_ERROR));
    }

    @Test
    void updateInvalid() throws Exception {
        Dish invalid = new Dish(DISH_ID, null);
        perform(MockMvcRequestBuilders.put(REST_URL + DISH_ID)
                .contentType(MediaType.APPLICATION_JSON)
                .content(JsonUtil.writeValue(invalid))
                .with(userHttpBasic(admin)))
                .andDo(print())
                .andExpect(status().isUnprocessableEntity())
                .andExpect(errorType(VALIDATION_ERROR));
    }

    @Test
    @Transactional(propagation = Propagation.NEVER)
    void updateDuplicate() throws Exception {
        Dish invalid = new Dish(DISH_ID, "Суп");

        perform(MockMvcRequestBuilders.put(REST_URL + DISH_ID)
                .contentType(MediaType.APPLICATION_JSON)
                .content(JsonUtil.writeValue(invalid))
                .with(userHttpBasic(admin)))
                .andDo(print())
                .andExpect(status().isConflict())
                .andExpect(errorType(DATA_ERROR))
                .andExpect(detailMessage("integrity constraint violation: unique constraint or index violation: DISH_UNIQUE_NAME_IDX"));
    }

    @Test
    void createWithLocation() throws Exception {
        Dish newDish = DishTestData.getNew();
        ResultActions action = perform(MockMvcRequestBuilders.post(REST_URL)
                .contentType(MediaType.APPLICATION_JSON)
                .with(userHttpBasic(admin))
                .content(JsonUtil.writeValue(newDish)));

        Dish created = MATCHER.readFromJson(action);
        int newId = created.id();
        newDish.setId(newId);
        MATCHER.assertMatch(created, newDish);
        MATCHER.assertMatch(dishService.get(newId), newDish);
    }

    @Test
    void createInvalid() throws Exception {
        Dish invalid = new Dish(null, "");
        perform(MockMvcRequestBuilders.post(REST_URL)
                .contentType(MediaType.APPLICATION_JSON)
                .content(JsonUtil.writeValue(invalid))
                .with(userHttpBasic(admin)))
                .andDo(print())
                .andExpect(status().isUnprocessableEntity())
                .andExpect(errorType(VALIDATION_ERROR));
    }

    @Test
    @Transactional(propagation = Propagation.NEVER)
    void createDuplicate() throws Exception {
        Dish invalid = new Dish(null, "Салат");
        perform(MockMvcRequestBuilders.post(REST_URL)
                .contentType(MediaType.APPLICATION_JSON)
                .content(JsonUtil.writeValue(invalid))
                .with(userHttpBasic(admin)))
                .andDo(print())
                .andExpect(status().isConflict())
                .andExpect(errorType(DATA_ERROR))
                .andExpect(detailMessage("integrity constraint violation: unique constraint or index violation: DISH_UNIQUE_NAME_IDX"));
    }

    @Test
    void getAll() throws Exception {
        perform(MockMvcRequestBuilders.get(REST_URL)
                .with(userHttpBasic(admin)))
                .andExpect(status().isOk())
                .andDo(print())
                .andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
                .andExpect(MATCHER.contentJson(dishes));

    }

}