package ru.kosmos.restaurantratingsystem.web;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = RestaurantsRestController.REST_URL, produces = MediaType.APPLICATION_JSON_VALUE)
public class RestaurantsRestController {

    static final String REST_URL = "/rest/restaurants";


}
