package ru.kosmos.restaurantratingsystem.web.controllers.users;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.*;
import ru.kosmos.restaurantratingsystem.dto.UsersDTO;
import ru.kosmos.restaurantratingsystem.model.Users;

import javax.validation.Valid;

import static ru.kosmos.restaurantratingsystem.web.SecurityUtil.authUserId;

@RestController
@RequestMapping(value = ProfileRestController.REST_URL, produces = MediaType.APPLICATION_JSON_VALUE)
@Secured("ROLE_USER")
public class ProfileRestController extends AbstractUserController {

    static final String REST_URL = "/rest/profile";

    @GetMapping
    public Users getByIdWithRoles() {
        return super.getByIdWithRoles(authUserId());
    }

    @DeleteMapping
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete() {
        super.delete(authUserId());
    }

    @PutMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void update(@Valid @RequestBody UsersDTO usersDto) {
        super.update(usersDto, authUserId());
    }

}
