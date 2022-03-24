package ru.kosmos.restaurantratingsystem.util;

import ru.kosmos.restaurantratingsystem.dto.RestaurantDTO;
import ru.kosmos.restaurantratingsystem.model.Menu;
import ru.kosmos.restaurantratingsystem.model.Restaurant;
import ru.kosmos.restaurantratingsystem.model.Votes;
import ru.kosmos.restaurantratingsystem.web.SecurityUtil;

import java.util.Collection;
import java.util.List;
import java.util.Set;

public class RestaurantUtil {

    public static List<RestaurantDTO> getDTOs(Collection<Restaurant> restaurants) {
        return restaurants.stream()
                .map(RestaurantUtil::createDTO)
                .toList();
    }

    public static RestaurantDTO createDTO(Restaurant restaurant) {
        Menu menu = restaurant.getMenues().stream().findFirst().orElse(null);
        if (menu == null || menu.getVotes() == null)
            return new RestaurantDTO(restaurant.getId(), restaurant.getName(), restaurant.getMenues(), 0, false);

        Set<Votes> votes = menu.getVotes();
        Integer countVotes = votes.size();
        boolean isVoted = votes.stream().anyMatch(votes1 -> votes1.getUser().getId() == SecurityUtil.authUserId());
        return new RestaurantDTO(restaurant.getId(), restaurant.getName(), restaurant.getMenues(), countVotes, isVoted);
    }

}
