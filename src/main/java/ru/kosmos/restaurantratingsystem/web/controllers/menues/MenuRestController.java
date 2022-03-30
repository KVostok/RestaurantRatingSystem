package ru.kosmos.restaurantratingsystem.web.controllers.menues;

import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import ru.kosmos.restaurantratingsystem.View;
import ru.kosmos.restaurantratingsystem.dto.MenuDTO;
import ru.kosmos.restaurantratingsystem.model.Menu;

import java.net.URI;

import static ru.kosmos.restaurantratingsystem.util.MenuUtil.asEntity;

@RestController
@RequestMapping(value = MenuRestController.REST_URL, produces = MediaType.APPLICATION_JSON_VALUE)
@Secured("ROLE_ADMIN")
public class MenuRestController extends AbstractMenuRestController {

    static final String REST_URL = "/rest/menues";

    @Override
    @GetMapping("/{id}")
    public Menu getWithDishes(@PathVariable int id) {
        return super.getWithDishes(id);
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Menu> createWithLocation(@Validated(View.Web.class) @RequestBody MenuDTO menuDto) {
        Menu created = super.create(asEntity(menuDto));
        URI uriOfNewResource = ServletUriComponentsBuilder.fromCurrentContextPath()
                .path(REST_URL + "/{id}")
                .buildAndExpand(created.getId()).toUri();
        return ResponseEntity.created(uriOfNewResource).body(created);
    }

}
