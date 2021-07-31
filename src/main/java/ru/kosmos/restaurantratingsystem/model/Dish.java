package ru.kosmos.restaurantratingsystem.model;

import org.hibernate.validator.constraints.Range;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "dish")
public class Dish extends AbstractNamedEntity {

    @Column(name = "price", nullable = false, columnDefinition = "int default 0")
    @Range(max = 50000)
    private Integer price;

    public Dish() {
    }

    public Dish(Integer id, String name, @Range(max = 50000) Integer price) {
        super(id, name);
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
        return "Dish{" +
                "price=" + price +
                ", name='" + name + '\'' +
                ", id=" + id +
                '}';
    }
}
