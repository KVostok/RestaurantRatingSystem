package ru.kosmos.restaurantratingsystem.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;
import ru.kosmos.restaurantratingsystem.model.Users;

@Transactional(readOnly = true)
public interface CrudUserRepository extends JpaRepository<Users, Integer> {
    @Transactional
    @Modifying
    @Query("DELETE FROM Users u WHERE u.id=:id")
    int delete(@Param("id") int id);

    Users getByEmail(String email);
}
