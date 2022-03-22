package ru.kosmos.restaurantratingsystem.model;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.Set;

@Entity
@Table(name = "dish")
public class Dish extends AbstractNamedEntity {

    @OneToMany(mappedBy = "dish")
    @JsonBackReference
    private Set<Dishes> dishes;

    @Override
    public String toString() {
        return "Dish{" +
                "name='" + name + '\'' +
                ", id dish=" + id +
                '}';
    }
}
