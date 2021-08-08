package ru.kosmos.restaurantratingsystem.model;

import org.hibernate.validator.constraints.Range;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "dishes")
public class Dishes extends AbstractBaseEntity{
    @Column(name = "price", nullable = false, columnDefinition = "int default 0")
    @Range(max = 50000)
    private Integer price;

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
        return "Dishes{" +
                "price=" + price +
                ", id=" + id +
                '}';
    }
}
