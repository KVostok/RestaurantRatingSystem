package ru.kosmos.restaurantratingsystem.model;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "ROLES")
public class Roles extends AbstractBaseEntity{
    public Roles() {
    }

    public Roles(Integer id) {
        super(id);
    }

    @Override
    public String toString() {
        return "Roles{" +
                "id=" + id +
                '}';
    }
}
