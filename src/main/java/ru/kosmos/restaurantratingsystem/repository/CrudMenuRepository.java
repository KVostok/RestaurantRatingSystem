package ru.kosmos.restaurantratingsystem.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;
import ru.kosmos.restaurantratingsystem.model.Menu;

@Transactional(readOnly = true)
public interface CrudMenuRepository extends JpaRepository<Menu, Integer> {

    @Query("SELECT m FROM Menu m WHERE m.restaurant.id=:restaurantId and m.date=current_date")
    Menu getMenuOnToday(@Param("restaurantId") int restaurantId);
}
