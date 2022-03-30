package ru.kosmos.restaurantratingsystem.web.controllers.restaurants;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import ru.kosmos.restaurantratingsystem.View;
import ru.kosmos.restaurantratingsystem.dto.RestaurantDTO;
import ru.kosmos.restaurantratingsystem.model.Restaurant;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping(value = RestaurantsRestController.REST_URL, produces = MediaType.APPLICATION_JSON_VALUE)
public class RestaurantsRestController extends AbstractRestaurantRestController {

    static final String REST_URL = "/rest/restaurants";

    @Override
    @GetMapping("/{id}")
    @Secured("ROLE_ADMIN")
    public Restaurant get(@PathVariable int id) {
        return super.get(id);
    }

    @Override
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @Secured("ROLE_ADMIN")
    public void delete(@PathVariable int id) {
        super.delete(id);
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    @Secured("ROLE_ADMIN")
    public ResponseEntity<Restaurant> createWithLocation(@Validated(View.Web.class) @RequestBody Restaurant restaurant) {
        Restaurant created = super.create(restaurant);
        URI uriOfNewResource = ServletUriComponentsBuilder.fromCurrentContextPath()
                .path(REST_URL + "/{id}")
                .buildAndExpand(created.getId()).toUri();
        return ResponseEntity.created(uriOfNewResource).body(created);
    }

    @Override
    @PutMapping(value = "/{id}", consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @Secured("ROLE_ADMIN")
    public void update(@Validated(View.Web.class) @RequestBody Restaurant restaurant, @PathVariable int id) {
        super.update(restaurant, id);
    }

    @Override
    @GetMapping
    @Secured({"ROLE_ADMIN", "ROLE_USER"})
    public List<RestaurantDTO> getAllWithMenu() {
        return super.getAllWithMenu();
    }

}
