package ru.kosmos.restaurantratingsystem.web.controllers.votes;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import ru.kosmos.restaurantratingsystem.MatcherFactory;
import ru.kosmos.restaurantratingsystem.model.Votes;
import ru.kosmos.restaurantratingsystem.service.VoteService;
import ru.kosmos.restaurantratingsystem.util.validation.ValidationUtil;
import ru.kosmos.restaurantratingsystem.web.AbstractControllerTest;

import java.time.LocalTime;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static ru.kosmos.restaurantratingsystem.testdata.MenuTestData.menu;
import static ru.kosmos.restaurantratingsystem.testdata.UsersTestData.*;
import static ru.kosmos.restaurantratingsystem.util.exception.ErrorType.APP_ERROR;

class VoteRestControllerTest extends AbstractControllerTest {

    public static final MatcherFactory.Matcher<Votes> MATCHER = MatcherFactory.usingEqualsComparator(Votes.class);
    private static final String REST_URL = VoteRestController.REST_URL + '/';

    @Autowired
    private VoteService service;

    @Test
    void getUnAuth() throws Exception {
        perform(MockMvcRequestBuilders.post(REST_URL))
                .andExpect(status().isUnauthorized())
                .andDo(print());
    }

    @Test
    void createWithLocationNewVoteBeforeConstraint() throws Exception {
        ValidationUtil.TIME_CONSTRAINT = LocalTime.now().plusMinutes(5);
        Votes newVote = new Votes(menu, user12);
        ResultActions action = perform(MockMvcRequestBuilders.post(REST_URL)
                .param("menuId", "10000")
                .with(userHttpBasic(user12)))
                .andDo(print())
                .andExpect(status().isCreated())
                .andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON));

        newVote.setId(MATCHER.readFromJson(action).id());
        Votes created = service.getByIdWithMenuWithUser(newVote.id());
        MATCHER.assertMatch(created, newVote);
        ValidationUtil.TIME_CONSTRAINT = LocalTime.of(11, 0, 0);
    }

    @Test
    void createWithLocationNewVoteAfterConstraint() throws Exception {
        ValidationUtil.TIME_CONSTRAINT = LocalTime.now().minusMinutes(5);
        Votes newVote = new Votes(menu, user13);
        ResultActions action = perform(MockMvcRequestBuilders.post(REST_URL)
                .param("menuId", "10000")
                .with(userHttpBasic(user13)))
                .andDo(print())
                .andExpect(status().isCreated())
                .andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON));

        newVote.setId(MATCHER.readFromJson(action).id());
        Votes created = service.getByIdWithMenuWithUser(newVote.id());
        MATCHER.assertMatch(created, newVote);
        ValidationUtil.TIME_CONSTRAINT = LocalTime.of(11, 0, 0);
    }

    @Test
    void createWithLocationChangeVoteBeforeConstraint() throws Exception {
        ValidationUtil.TIME_CONSTRAINT = LocalTime.now().plusMinutes(5);
        perform(MockMvcRequestBuilders.post(REST_URL)
                .param("menuId", "10001")
                .with(userHttpBasic(user1)))
                .andDo(print())
                .andExpect(status().isCreated())
                .andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON));

        ValidationUtil.TIME_CONSTRAINT = LocalTime.of(11, 0, 0);
    }

    @Test
    void createWithLocationChangeVoteAfterConstraint() throws Exception {
        ValidationUtil.TIME_CONSTRAINT = LocalTime.now().minusMinutes(5);
        perform(MockMvcRequestBuilders.post(REST_URL)
                .param("menuId", "10001")
                .with(userHttpBasic(user1)))
                .andDo(print())
                .andExpect(status().isInternalServerError())
                .andExpect(errorType(APP_ERROR));

        ValidationUtil.TIME_CONSTRAINT = LocalTime.of(11, 0, 0);
    }

}