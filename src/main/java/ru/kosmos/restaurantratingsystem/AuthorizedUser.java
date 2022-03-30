package ru.kosmos.restaurantratingsystem;

import ru.kosmos.restaurantratingsystem.dto.UsersDTO;
import ru.kosmos.restaurantratingsystem.model.Users;
import ru.kosmos.restaurantratingsystem.util.UsersUtil;

import java.io.Serial;

public class AuthorizedUser extends org.springframework.security.core.userdetails.User {

    @Serial
    private static final long serialVersionUID = 1L;

    private UsersDTO usersDto;

    public AuthorizedUser(Users users) {
        super(users.getEmail(), users.getPassword(), users.isEnabled(), true, true, true, users.getRoles());
        setTo(UsersUtil.asTo(users));
    }

    public int getId() {
        return usersDto.id();
    }

    public void setTo(UsersDTO newDto) {
        newDto.setPassword(null);
        usersDto = newDto;
    }

    public UsersDTO getUsersDto() {
        return usersDto;
    }

    @Override
    public String toString() {
        return usersDto.toString();
    }

}
