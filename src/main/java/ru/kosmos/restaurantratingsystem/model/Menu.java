package ru.kosmos.restaurantratingsystem.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;

@Entity
@Table(name = "MENU")
public class Menu extends AbstractBaseEntity{
    @Column(name = "DATE", nullable = false)
    @NotNull
    private LocalDate date;

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

    @Override
    public String toString() {
        return "Menu{" +
                "date=" + date +
                ", id=" + id +
                '}';
    }
}
