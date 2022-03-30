package ru.kosmos.restaurantratingsystem.web.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import springfox.documentation.annotations.ApiIgnore;

@ApiIgnore
@Controller
public class RootController {

    @GetMapping("/")
    public String root() {
        return "redirect:rest/restaurants";
    }

}
