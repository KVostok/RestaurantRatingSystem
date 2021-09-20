package ru.kosmos.restaurantratingsystem.web.controllers.votes;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import ru.kosmos.restaurantratingsystem.dto.VotesDTO;
import ru.kosmos.restaurantratingsystem.model.Votes;
import ru.kosmos.restaurantratingsystem.service.VoteService;
import ru.kosmos.restaurantratingsystem.util.VotesUtil;
import ru.kosmos.restaurantratingsystem.web.SecurityUtil;

import java.util.List;

import static ru.kosmos.restaurantratingsystem.util.validation.ValidationUtil.assureIdConsistent;
import static ru.kosmos.restaurantratingsystem.util.validation.ValidationUtil.checkNew;

public abstract class AbstractVoteRestController {
    private final Logger log = LoggerFactory.getLogger(getClass());

    @Autowired
    private VoteService voteService;

    public Votes get(int id) {
        log.info("get vote {}" , id);
        return voteService.get(id);
    }

    public void delete(int id) {
        log.info("delete vote {}", id);
        voteService.delete(id);
    }

    public Votes create(int menuId) {
        int userId = SecurityUtil.authUserId();
        log.info("create vote for menu with id {} and  user with id {}", menuId, userId);
        return voteService.create(menuId, userId);
    }

    public void update(Votes votes, int id) {
        log.info("update vote {}", votes);
        assureIdConsistent(votes, id);
        voteService.update(votes);
    }

    public List<VotesDTO> getAll() {
        log.info("getAllVotes");
        return VotesUtil.getDTOs(voteService.getAll());
    }

}
