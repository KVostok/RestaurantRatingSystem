package ru.kosmos.restaurantratingsystem.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.util.Set;

@Entity
@Table(name = "menu")
public class Menu extends AbstractBaseEntity {
    @Column(name = "DATE", nullable = false)
    @NotNull
    private LocalDate date;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "RESTAURANT_ID", nullable = false)
    @JsonBackReference
    private Restaurant restaurant;

    @OneToMany(mappedBy = "menu", cascade = CascadeType.ALL)
    private Set<Dishes> dishes;

    @JsonIgnore
    @OneToMany(mappedBy = "menu")
    private Set<Votes> votes;

    public Menu() {
    }

    public Menu(Integer id, @NotNull LocalDate date) {
        super(id);
        this.date = date;
    }

    public Menu(@NotNull Restaurant restaurant, @NotNull Set<Dishes> dishes) {
        this.restaurant = restaurant;
        //https://javascopes.com/jpa-hibernate-synchronize-bidirectional-entity-associations-2ccfb961/
        //https://coderlessons.com/articles/java/rukovodstvo-dlia-nachinaiushchikh-po-jpa-i-hibernate-cascade-types
        //https://sysout.ru/tipy-cascade-primer-na-hibernate-i-spring-boot/
        dishes.forEach(d -> d.setMenu(this));
        this.dishes = dishes;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public Set<Votes> getVotes() {
        return votes;
    }

    @Override
    public String toString() {
        return "\nMenu{" +
                "date=" + date +
                ",\n dishes=" + dishes +
                ",\n votes=" + votes +
                ",\n id menu=" + id +
                ",\n id restaurant=" + restaurant.id +
                '}';
    }
}
