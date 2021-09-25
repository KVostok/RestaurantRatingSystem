package ru.kosmos.restaurantratingsystem.service;

import org.springframework.stereotype.Service;
import org.springframework.util.Assert;
import ru.kosmos.restaurantratingsystem.model.Votes;
import ru.kosmos.restaurantratingsystem.repository.MenuRepository;
import ru.kosmos.restaurantratingsystem.repository.UserRepository;
import ru.kosmos.restaurantratingsystem.repository.VoteRepository;

import java.util.List;

import static ru.kosmos.restaurantratingsystem.util.validation.ValidationUtil.checkNotFoundWithId;

@Service
public class VoteService {
    private final VoteRepository voteRepository;
    private final MenuRepository menuRepository;
    private final UserRepository userRepository;

    public VoteService(VoteRepository voteRepository, MenuRepository menuRepository, UserRepository userRepository) {
        this.voteRepository = voteRepository;
        this.menuRepository = menuRepository;
        this.userRepository = userRepository;
    }

    public List<Votes> getAll() {
        return voteRepository.getAll();
    }

    public Votes get(int id) {
        return checkNotFoundWithId(voteRepository.get(id), id);
    }

    public void delete(int id) {
        checkNotFoundWithId(voteRepository.delete(id), id);
    }

    public Votes create(int menuId, int userId) {
        Votes votes = voteRepository.getWithMenuForUserWithId(userId);
        if (votes == null) {
            votes = new Votes(menuRepository.get(menuId), userRepository.get(userId));
        }
        else {

        }
        return voteRepository.save(votes);
    }

    public Votes update(Votes votes) {
        Assert.notNull(votes, "Votes must not be null");
        return voteRepository.save(votes);
    }
}
