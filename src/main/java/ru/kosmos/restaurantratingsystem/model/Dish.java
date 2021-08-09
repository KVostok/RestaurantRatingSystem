package ru.kosmos.restaurantratingsystem.model;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "dish")
public class Dish extends AbstractNamedEntity {

    public Dish() {
    }

    @Override
    public String toString() {
        return "Dish{" +
                "name='" + name + '\'' +
                ", id=" + id +
                '}';
    }
}
