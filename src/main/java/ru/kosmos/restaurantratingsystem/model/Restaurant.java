package ru.kosmos.restaurantratingsystem.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.util.Set;

@Entity
@NamedEntityGraphs({
        @NamedEntityGraph(
                name = "allJoined",
                attributeNodes = {
                        @NamedAttributeNode(value = "menues", subgraph = "menues-sub")
                },
                subgraphs = {
                        @NamedSubgraph(
                                name = "menues-sub",
                                attributeNodes = {
                                        @NamedAttributeNode(value = "dishes", subgraph = "dishes-sub"),
                                        @NamedAttributeNode(value = "votes"),
                                }
                        ),
                        @NamedSubgraph(
                                name = "dishes-sub",
                                attributeNodes = @NamedAttributeNode("dish")
                        )
                }
        )
})
@Table(name = "restaurant")
public class Restaurant extends AbstractNamedEntity {

    @JsonIgnore
    @JsonManagedReference
    @OneToMany(mappedBy = "restaurant")
    private Set<Menu> menues;

    public Restaurant() {
    }

    public Restaurant(Integer id, String name) {
        super(id, name);
    }

    public Restaurant(Restaurant restaurant) {
        super(restaurant.id(), restaurant.getName());
        this.menues = restaurant.getMenues();
    }

    public Set<Menu> getMenues() {
        return menues;
    }

    public void setMenues(Set<Menu> menues) {
        this.menues = menues;
    }

    @Override
    public String toString() {
        return "\nRestaurant{" +
                "id rest=" + id +
                ", name='" + name +
                ",\n menues=" + menues +
                "}\n";
    }

}
