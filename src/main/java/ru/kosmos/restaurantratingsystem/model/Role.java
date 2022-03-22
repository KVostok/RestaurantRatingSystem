package ru.kosmos.restaurantratingsystem.model;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "role")
public class Role extends AbstractNamedEntity {

    @OneToMany(mappedBy = "role")
    private Set<Roles> roles;

    @Override
    public String toString() {
        return "Role{" +
                "name='" + name + '\'' +
                ", id=" + id +
                '}';
    }
}
