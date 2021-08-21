package ru.kosmos.restaurantratingsystem.model;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;

@Entity
@Table(name = "votes")
public class Votes extends AbstractBaseEntity{

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "MENU_ID", nullable = false)
    @JsonBackReference
    @OrderColumn
    private Menu menu;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "USER_ID", nullable = false)
    @JsonBackReference
    @OrderColumn
    private Users users;

    public Votes() {
    }

    @Override
    public String toString() {
        return "Votes{" +
                "id vote=" + id +
                '}';
    }
}
