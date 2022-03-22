package ru.kosmos.restaurantratingsystem.repository;

import org.springframework.stereotype.Repository;
import ru.kosmos.restaurantratingsystem.model.Votes;

import java.time.LocalDate;

@Repository
public class VoteRepository {
    private final CrudVoteRepository repository;

    public VoteRepository(CrudVoteRepository repository) {
        this.repository = repository;
    }

    public Votes save(Votes votes) {
        return repository.save(votes);
    }

    public Votes getForUser(int userId) {
        return repository.getWithMenuForUserOnToday(userId, LocalDate.now()).orElse(null);
    }

}
