package ru.kosmos.restaurantratingsystem.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import org.springframework.security.core.GrantedAuthority;

import javax.persistence.*;

@Entity
@Table(name = "roles")
public class Roles extends AbstractBaseEntity implements GrantedAuthority {

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "USER_ID", nullable = false)
    @JsonBackReference
    private Users user;

    @ManyToOne
    @JoinColumn(name = "ROLE_ID", nullable = false)
    private Role role;

    public Users getUser() {
        return user;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    //    https://stackoverflow.com/a/19542316/548473
    @Override
    public String getAuthority() {
        return "ROLE_" + getRole().getName();
    }

    @Override
    public String toString() {
        return "Roles{" +
                "id=" + id +
                '}';
    }

}
