package ru.kosmos.restaurantratingsystem.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import org.hibernate.validator.constraints.Range;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "dishes")
public class Dishes extends AbstractBaseEntity {

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

    public Dishes(@NotNull Dish dish, @NotNull Integer price) {
        this.dish = dish;
        this.price = price;
    }

    public Menu getMenu() {
        return menu;
    }

    public void setMenu(Menu menu) {
        this.menu = menu;
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
