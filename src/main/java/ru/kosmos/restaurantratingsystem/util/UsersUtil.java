package ru.kosmos.restaurantratingsystem.util;

import org.springframework.security.crypto.password.PasswordEncoder;
import ru.kosmos.restaurantratingsystem.dto.UsersDTO;
import ru.kosmos.restaurantratingsystem.model.Users;

public class UsersUtil {

    public static UsersDTO asTo(Users users) {
        return new UsersDTO(users.getId(), users.getName(), users.getEmail(), users.getPassword());
    }

    public static Users updateFromTo(Users users, UsersDTO usersDto) {
        users.setName(usersDto.getName());
        users.setEmail(usersDto.getEmail().toLowerCase());
        users.setPassword(usersDto.getPassword());
        return users;
    }

    public static Users prepareToSave(Users users, PasswordEncoder passwordEncoder) {
        users.getRoles().forEach(roles -> roles.setUser(users));
        users.setPassword(passwordEncoder.encode(users.getPassword()));
        users.setEmail(users.getEmail().toLowerCase());
        return users;
    }

}
