package ru.kosmos.restaurantratingsystem.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.Set;

@Entity
@Table(name = "role")
public class Role extends AbstractNamedEntity {

    @OneToMany(mappedBy = "role", fetch = FetchType.LAZY)
    @JsonIgnore
    private Set<Roles> roles;

    public Role() {
    }

    public Role(Integer id, String name) {
        super(id, name);
    }

    public void setRoles(Set<Roles> roles) {
        this.roles = roles;
    }

    public Set<Roles> getRoles() {
        return roles;
    }

    @Override
    public String toString() {
        return "Role{" +
                "name='" + name + '\'' +
                ", id=" + id +
                '}';
    }

}
