package ru.kosmos.restaurantratingsystem.model;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;

@Entity
@Table(name = "votes")
public class Votes extends AbstractBaseEntity{

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "MENU_ID", nullable = false)
    @JsonBackReference
    @OrderColumn
    private Menu menu;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "USER_ID", nullable = false)
    @JsonBackReference
    @OrderColumn
    private Users users;

    @Column(name = "USER_ID", nullable = false)
    private Integer userId;

    @Column(name = "MENU_ID", nullable = false)
    private Integer menuId;

    public Integer getUserId() {
        return userId;
    }

    public Integer getMenuId() {
        return menuId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public void setMenuId(Integer menuId) {
        this.menuId = menuId;
    }

    public Votes() {
    }

    public Votes(Integer menuId, Integer userId) {
        this.menuId = menuId;
        this.userId = userId;
    }

    @Override
    public String toString() {
        return "Votes{" +
                "id=" + id +
                ", userId=" + userId +
                ", menuId=" + menuId +
                '}';
    }
}
