package ru.kosmos.restaurantratingsystem.model;

import javax.persistence.*;

@Entity
@Table(name = "role")
public class Role extends AbstractNamedEntity {

    public Role() {
    }

    @Override
    public String toString() {
        return "Role{" +
                "name='" + name + '\'' +
                ", id=" + id +
                '}';
    }
}
