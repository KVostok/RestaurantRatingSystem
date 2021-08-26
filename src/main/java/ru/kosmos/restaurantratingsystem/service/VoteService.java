package ru.kosmos.restaurantratingsystem.service;

import org.springframework.stereotype.Service;
import org.springframework.util.Assert;
import ru.kosmos.restaurantratingsystem.model.Votes;
import ru.kosmos.restaurantratingsystem.repository.VoteRepository;

import java.util.List;

import static ru.kosmos.restaurantratingsystem.util.validation.ValidationUtil.checkNotFoundWithId;

@Service
public class VoteService {
    private final VoteRepository voteRepository;

    public VoteService(VoteRepository voteRepository) {
        this.voteRepository = voteRepository;
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

    public Votes create(Votes votes) {
        Assert.notNull(votes, "Votes must not be null");
        return voteRepository.save(votes);
    }

    public Votes update(Votes votes) {
        Assert.notNull(votes, "Votes must not be null");
        return voteRepository.save(votes);
    }
}
