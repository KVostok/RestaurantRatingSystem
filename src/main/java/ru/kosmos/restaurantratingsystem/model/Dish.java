package ru.kosmos.restaurantratingsystem.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.Set;

@Entity
@Table(name = "dish")
public class Dish extends AbstractNamedEntity {

    @OneToMany(mappedBy = "dish")
    @JsonIgnore
    private Set<Dishes> dishes;

    public Dish() {
    }

    public Dish(Integer id, String name) {
        super(id, name);
    }

    public Dish(Dish dish) {
        super(dish.getId(), dish.getName());
        this.dishes = dish.getDishes();
    }

    public void setDishes(Set<Dishes> dishes) {
        this.dishes = dishes;
    }

    public Set<Dishes> getDishes() {
        return dishes;
    }

    @Override
    public String toString() {
        return "Dish{" +
                "name='" + name + '\'' +
                ", id dish=" + id +
                '}';
    }

}
