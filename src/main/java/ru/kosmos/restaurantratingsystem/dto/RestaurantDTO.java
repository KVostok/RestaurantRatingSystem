package ru.kosmos.restaurantratingsystem.dto;

import ru.kosmos.restaurantratingsystem.model.Menu;

import java.beans.ConstructorProperties;
import java.util.Objects;
import java.util.Set;

public class RestaurantDTO extends BaseDTO{

    private final String name;
    private final Set<Menu> menues;

    @ConstructorProperties({"id", "name", "menues"})
    public RestaurantDTO(Integer id, String name, Set<Menu> menues) {
        super(id);
        this.name = name;
        this.menues = menues;
    }

    public String getName() {
        return name;
    }

    public Set<Menu> getMenues() {
        return menues;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RestaurantDTO that = (RestaurantDTO) o;
        return Objects.equals(getName(), that.getName());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getName());
    }

    @Override
    public String toString() {
        return "RestaurantDTO{" +
                "name='" + name + '\'' +
                ", menues=" + menues +
                ", id=" + id +
                '}';
    }
}
