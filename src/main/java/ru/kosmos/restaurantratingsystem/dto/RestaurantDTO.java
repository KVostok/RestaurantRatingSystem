package ru.kosmos.restaurantratingsystem.dto;

import ru.kosmos.restaurantratingsystem.model.Menu;

import java.beans.ConstructorProperties;
import java.util.Objects;
import java.util.Set;

public class RestaurantDTO extends BaseDTO {

    private final String name;
    private final Set<Menu> menues;
    private final Integer rating;
    private final boolean isVoted;

    @ConstructorProperties({"id", "name", "menues", "rating"})
    public RestaurantDTO(Integer id, String name, Set<Menu> menues, Integer rating, boolean isVoted) {
        super(id);
        this.name = name;
        this.menues = menues;
        this.rating = rating;
        this.isVoted = isVoted;
    }

    public String getName() {
        return name;
    }

    public Integer getRating() {
        return rating;
    }

    public boolean isVoted() {
        return isVoted;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RestaurantDTO that = (RestaurantDTO) o;
        return isVoted() == that.isVoted() &&
                Objects.equals(getName(), that.getName()) &&
                Objects.equals(getRating(), that.getRating());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getName(), getRating(), isVoted());
    }

    @Override
    public String toString() {
        return "RestaurantDTO{" +
                "name='" + name + '\'' +
                ", menues=" + menues +
                ", rating=" + rating +
                ", isVoted=" + isVoted +
                ", id=" + id +
                '}';
    }

}
