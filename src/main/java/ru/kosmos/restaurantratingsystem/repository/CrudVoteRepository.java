package ru.kosmos.restaurantratingsystem.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;
import ru.kosmos.restaurantratingsystem.model.Votes;

@Transactional(readOnly = true)
public interface CrudVoteRepository extends JpaRepository<Votes, Integer> {

}
