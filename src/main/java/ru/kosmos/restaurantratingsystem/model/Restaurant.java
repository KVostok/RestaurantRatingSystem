package ru.kosmos.restaurantratingsystem.model;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "restaurant")
public class Restaurant extends AbstractNamedEntity {

    @OneToMany(mappedBy = "restaurant")
    private List<Menu> menues;

    public List<Menu> getMenues() {
        return menues;
    }

    public void setMenues(List<Menu> menues) {
        this.menues = menues;
    }

    public Restaurant() {
    }

    @Override
    public String toString() {
        return "Restaurant{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", menues=" + menues +
                '}';
    }
}
