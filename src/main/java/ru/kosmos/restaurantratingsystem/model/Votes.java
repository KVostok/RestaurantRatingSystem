package ru.kosmos.restaurantratingsystem.model;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "VOTES")
public class Votes extends AbstractBaseEntity{
    public Votes() {
    }

    @Override
    public String toString() {
        return "Votes{" +
                "id=" + id +
                '}';
    }
}