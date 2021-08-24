package ru.kosmos.restaurantratingsystem.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import org.hibernate.validator.constraints.Range;

import javax.persistence.*;

@Entity
@Table(name = "dishes")
public class Dishes extends AbstractBaseEntity{
    @Column(name = "price", nullable = false, columnDefinition = "int default 0")
    @Range(max = 50000)
    private Integer price;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "MENU_ID", nullable = false)
    @JsonBackReference
    private Menu menu;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "DISH_ID", nullable = false)
    private Dish dish;

    public Dishes() {
    }

    public Dishes(Integer id, @Range(max = 50000) Integer price) {
        super(id);
        this.price = price;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "\nDishes{" +
                "price=" + price +
                ", dish=" + dish +
                ", id dishes=" + id +
                '}';
    }
}
