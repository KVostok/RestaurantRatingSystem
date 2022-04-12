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

    public Dishes(Integer id, Integer price, Dish dish) {
        super(id);
        this.price = price;
        this.dish = dish;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public Menu getMenu() {
        return menu;
    }

    public void setMenu(Menu menu) {
        this.menu = menu;
    }

    public Dish getDish() {
        return dish;
    }

    public void setDish(Dish dish) {
        this.dish = dish;
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
