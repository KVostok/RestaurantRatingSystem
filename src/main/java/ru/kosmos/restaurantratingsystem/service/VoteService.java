package ru.kosmos.restaurantratingsystem.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.kosmos.restaurantratingsystem.model.Votes;
import ru.kosmos.restaurantratingsystem.repository.VoteRepository;
import ru.kosmos.restaurantratingsystem.util.exception.VoteCantBeChangedException;

import java.time.LocalTime;

import static ru.kosmos.restaurantratingsystem.util.validation.ValidationUtil.TIME_CONSTRAINT;

@Service
public class VoteService {

    private final VoteRepository voteRepository;
    private final MenuService menuService;
    private final UserService userService;

    public VoteService(VoteRepository voteRepository, MenuService menuService, UserService userService) {
        this.voteRepository = voteRepository;
        this.menuService = menuService;
        this.userService = userService;
    }

    @Transactional
    public Votes create(int userId, int menuId) {
        Votes votes = voteRepository.getForUser(userId);

        if (votes == null)
            return voteRepository.save(new Votes(menuService.get(menuId), userService.get(userId)));
        if (!LocalTime.now().isBefore(TIME_CONSTRAINT))
            throw new VoteCantBeChangedException("Vote can't be changed after 11-00");

        votes.setMenu(menuService.get(menuId));
        return voteRepository.save(votes);
    }

}
