package ru.kosmos.restaurantratingsystem.service;

import org.springframework.stereotype.Service;
import ru.kosmos.restaurantratingsystem.repository.MenuRepository;
import ru.kosmos.restaurantratingsystem.repository.VoteRepository;

@Service
public class VoteService {
    private final VoteRepository voteRepository;

    public VoteService(VoteRepository voteRepository) {
        this.voteRepository = voteRepository;
    }
}
