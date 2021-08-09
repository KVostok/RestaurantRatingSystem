package ru.kosmos.restaurantratingsystem.model;

import javax.persistence.*;

@Entity
@Table(name = "restaurant")
public class Restaurant extends AbstractNamedEntity {

    public Restaurant() {
    }

    @Override
    public String toString() {
        return "Restaurant{" +
                "name='" + name + '\'' +
                ", id=" + id +
                '}';
    }
}
