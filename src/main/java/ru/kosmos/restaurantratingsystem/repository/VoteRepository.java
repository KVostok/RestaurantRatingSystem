package ru.kosmos.restaurantratingsystem.repository;

import org.springframework.stereotype.Repository;

@Repository
public class VoteRepository {
    private final CrudVoteRepository repository;

    public VoteRepository(CrudVoteRepository repository) {
        this.repository = repository;
    }
}
