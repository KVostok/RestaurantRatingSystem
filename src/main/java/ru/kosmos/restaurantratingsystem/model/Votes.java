package ru.kosmos.restaurantratingsystem.model;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;

@Entity
@Table(name = "votes")
public class Votes extends AbstractBaseEntity {

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "MENU_ID", nullable = false)
    @JsonBackReference
    @OrderColumn
    private Menu menu;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "USER_ID", nullable = false)
    @JsonBackReference
    @OrderColumn
    private Users user;

    public Menu getMenu() {
        return menu;
    }

    public void setMenu(Menu menu) {
        this.menu = menu;
    }

    public Users getUser() {
        return user;
    }

    public Votes() {
    }

    public Votes(Menu menu, Users user) {
        this.menu = menu;
        this.user = user;
    }

    @Override
    public String toString() {
        return "Votes{" +
                "id=" + id +
                ", userId=" + user.getId() +
                ", menuId=" + menu.getId() +
                '}';
    }

}
