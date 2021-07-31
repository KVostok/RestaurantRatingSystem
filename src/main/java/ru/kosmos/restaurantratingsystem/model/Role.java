package ru.kosmos.restaurantratingsystem.model;

import org.springframework.data.domain.Persistable;

import javax.persistence.*;

@Entity
@Table(name = "role")
public class Role extends AbstractNamedEntity {

    public Role() {
    }

    public Role(Integer id, String name) {
        super(id, name);
    }

    @Override
    public String toString() {
        return "Role{" +
                "name='" + name + '\'' +
                ", id=" + id +
                '}';
    }
}
