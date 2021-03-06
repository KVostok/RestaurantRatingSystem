package ru.kosmos.restaurantratingsystem.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;

@Entity
@Table(name = "votes")
public class Votes extends AbstractBaseEntity {

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "MENU_ID", nullable = false)
    @JsonIgnore
    @OrderColumn
    private Menu menu;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "USER_ID", nullable = false)
    @JsonIgnore
    @OrderColumn
    private Users user;

    public Users getUser() {
        return user;
    }

    public void setUser(Users user) {
        this.user = user;
    }

    public Menu getMenu() {
        return menu;
    }

    public void setMenu(Menu menu) {
        this.menu = menu;
    }

    public Votes() {
    }

    public Votes(Menu menu, Users user) {
        this.menu = menu;
        this.user = user;
    }

    public Votes(Integer id, Menu menu, Users user) {
        super(id);
        this.menu = menu;
        this.user = user;
    }

    @Override
    public String toString() {
        return "\nVotes{" +
                "id=" + id +
                ", userId=" + (user == null ? "null" : user.getId()) +
                ", menuId=" + (user == null ? "null" : menu.getId()) +
                '}';
    }

}
