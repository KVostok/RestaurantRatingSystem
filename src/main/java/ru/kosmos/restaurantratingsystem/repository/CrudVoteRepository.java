package ru.kosmos.restaurantratingsystem.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;
import ru.kosmos.restaurantratingsystem.model.Votes;

import java.time.LocalDate;
import java.util.Optional;

@Transactional(readOnly = true)
public interface CrudVoteRepository extends JpaRepository<Votes, Integer> {

    @Transactional
    @Modifying
    @Query("DELETE FROM Votes v WHERE v.id=:id")
    int delete(@Param("id") int id);

    @Query("select v.id from Votes v join fetch v.menu m where v.userId=:user_id and m.date=:today")
    Optional<Votes> getWithMenuForUserByDateIsNow(@Param("user_id") int id, @Param("today") LocalDate today);
}
