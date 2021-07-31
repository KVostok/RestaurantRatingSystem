package ru.kosmos.restaurantratingsystem.model;

import org.springframework.data.domain.Persistable;

import javax.persistence.*;

@Entity
@Table(name = "restaurant")
public class Restaurant extends AbstractNamedEntity {

    public Restaurant() {
    }

    public Restaurant(Integer id, String name) {
        super(id, name);
    }

    @Override
    public String toString() {
        return "Restaurant{" +
                "name='" + name + '\'' +
                ", id=" + id +
                '}';
    }
}
