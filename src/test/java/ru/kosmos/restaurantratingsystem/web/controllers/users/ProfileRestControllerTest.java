package ru.kosmos.restaurantratingsystem.web.controllers.users;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import ru.kosmos.restaurantratingsystem.dto.UsersDTO;
import ru.kosmos.restaurantratingsystem.model.Users;
import ru.kosmos.restaurantratingsystem.service.UserService;
import ru.kosmos.restaurantratingsystem.util.UsersUtil;
import ru.kosmos.restaurantratingsystem.web.AbstractControllerTest;
import ru.kosmos.restaurantratingsystem.web.json.JsonUtil;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static ru.kosmos.restaurantratingsystem.testdata.UsersTestData.*;
import static ru.kosmos.restaurantratingsystem.util.exception.ErrorType.DATA_ERROR;
import static ru.kosmos.restaurantratingsystem.util.exception.ErrorType.VALIDATION_ERROR;
import static ru.kosmos.restaurantratingsystem.web.controllers.users.ProfileRestController.REST_URL;

class ProfileRestControllerTest extends AbstractControllerTest {

    @Autowired
    private UserService userService;

    @Test
    void getByIdWithRoles() throws Exception {
        perform(MockMvcRequestBuilders.get(REST_URL)
                .with(userHttpBasic(user1)))
                .andExpect(status().isOk())
                .andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
                .andExpect(MATCHER.contentJson(user1));
    }

    @Test
    void getUnAuth() throws Exception {
        perform(MockMvcRequestBuilders.get(REST_URL))
                .andExpect(status().isUnauthorized());
    }

    @Test
    void delete() throws Exception {
        userService.switchOfModificationRestriction();
        perform(MockMvcRequestBuilders.delete(REST_URL)
                .with(userHttpBasic(user1)))
                .andExpect(status().isNoContent());
        userService.switchOnModificationRestriction();
        MATCHER.assertMatch(userService.getAll(), admin, user2, user3, user4, user5, user6, user7, user8, user9,
                user10, user11, user12, user13, user14, user15, user16, user17, user18, user19, user20);
    }

    @Test
    void update() throws Exception {
        UsersDTO updatedDto = new UsersDTO(null, "newName", "user1@yandex.ru", "newPassword");
        userService.switchOfModificationRestriction();

        perform(MockMvcRequestBuilders.put(REST_URL)
                .contentType(MediaType.APPLICATION_JSON)
                .with(userHttpBasic(user1))
                .content(JsonUtil.writeValue(updatedDto)))
                .andDo(print())
                .andExpect(status().isNoContent());
        userService.switchOnModificationRestriction();
        MATCHER.assertMatch(userService.get(USER_ID), UsersUtil.updateFromTo(new Users(user1), updatedDto));
    }

    @Test
    void updateInvalid() throws Exception {
        UsersDTO updatedDto = new UsersDTO(null, null, "password", null);
        userService.switchOfModificationRestriction();
        perform(MockMvcRequestBuilders.put(REST_URL)
                .contentType(MediaType.APPLICATION_JSON)
                .with(userHttpBasic(user1))
                .content(JsonUtil.writeValue(updatedDto)))
                .andDo(print())
                .andExpect(status().isUnprocessableEntity())
                .andExpect(errorType(VALIDATION_ERROR));
        userService.switchOnModificationRestriction();
    }

    @Test
    @Transactional(propagation = Propagation.NEVER)
    void updateDuplicate() throws Exception {
        UsersDTO updatedDto = new UsersDTO(null, "newName", "admin@gmail.com", "newPassword");
        userService.switchOfModificationRestriction();
        perform(MockMvcRequestBuilders.put(REST_URL)
                .contentType(MediaType.APPLICATION_JSON)
                .with(userHttpBasic(user1))
                .content(JsonUtil.writeValue(updatedDto)))
                .andDo(print())
                .andExpect(status().isConflict())
                .andExpect(errorType(DATA_ERROR))
                .andExpect(detailMessage("integrity constraint violation: unique constraint or index violation: USERS_UNIQUE_EMAIL_IDX"));
        userService.switchOnModificationRestriction();
    }

}