package ru.kosmos.restaurantratingsystem.web.controllers.votes;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import ru.kosmos.restaurantratingsystem.model.Votes;
import ru.kosmos.restaurantratingsystem.service.VoteService;
import ru.kosmos.restaurantratingsystem.web.SecurityUtil;

public abstract class AbstractVoteRestController {

    private final Logger log = LoggerFactory.getLogger(getClass());

    @Autowired
    private VoteService voteService;

    public Votes create(int menuId) {
        int userId = SecurityUtil.authUserId();
        log.info("create vote of user with id {} for menu with id {}", userId, menuId);
        return voteService.create(userId, menuId);
    }

}
