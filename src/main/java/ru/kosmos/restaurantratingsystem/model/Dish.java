package ru.kosmos.restaurantratingsystem.model;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.Set;

@Entity
@Table(name = "dish")
public class Dish extends AbstractNamedEntity {

    @OneToMany(mappedBy = "dish")
    private Set<Dishes> dishes;

    public Dish() {
    }

    @Override
    public String toString() {
        return "Dish{" +
                "name='" + name + '\'' +
                ", id dish=" + id +
                '}';
    }
}
