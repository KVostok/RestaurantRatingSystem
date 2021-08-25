package ru.kosmos.restaurantratingsystem.model;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.util.Set;

@Entity
@Table(name = "menu")
public class Menu extends AbstractBaseEntity{
    @Column(name = "DATE", nullable = false)
    @NotNull
    private LocalDate date;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "RESTAURANT_ID", nullable = false)
    @JsonBackReference
    private Restaurant restaurant;

    @OneToMany(mappedBy = "menu")
    private Set<Dishes> dishes;

    //@JsonBackReference
    @OneToMany(mappedBy = "menu")
    private Set<Votes> votes;

    public Menu() {
    }

    public Menu(Integer id, @NotNull LocalDate date) {
        super(id);
        this.date = date;
    }

    public LocalDate getDate() {
        return date;
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
                '}';
    }
}
