package ru.kosmos.restaurantratingsystem.repository;

import org.springframework.stereotype.Repository;
import ru.kosmos.restaurantratingsystem.model.Votes;

import java.util.List;

import static ru.kosmos.restaurantratingsystem.util.validation.ValidationUtil.TODAY;

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
        return repository.getWithMenuForUserOnToday(userId, TODAY).orElse(null);
    }

    public boolean delete(int id) {
        return repository.delete(id) !=0;
    }

    public Votes get(int id) {
        return repository.findById(id).orElse(null);
    }

    public List<Votes> getAll() {
        return repository.findAll();
    }

}
