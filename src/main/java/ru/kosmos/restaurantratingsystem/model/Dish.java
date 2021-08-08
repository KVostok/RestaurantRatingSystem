package ru.kosmos.restaurantratingsystem.model;

import org.hibernate.validator.constraints.Range;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "dish")
public class Dish extends AbstractNamedEntity {

    public Dish() {
    }

    public Dish(Integer id, String name) {
        super(id, name);
    }

    @Override
    public String toString() {
        return "Dish{" +
                "name='" + name + '\'' +
                ", id=" + id +
                '}';
    }
}
