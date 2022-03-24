package ru.kosmos.restaurantratingsystem.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;
import ru.kosmos.restaurantratingsystem.model.Users;
import ru.kosmos.restaurantratingsystem.repository.UserRepository;

import java.util.List;

import static ru.kosmos.restaurantratingsystem.util.validation.ValidationUtil.checkNotFound;
import static ru.kosmos.restaurantratingsystem.util.validation.ValidationUtil.checkNotFoundWithId;

@Service
public class UserService {

    private final UserRepository repository;

    public UserService(UserRepository repository) {
        this.repository = repository;
    }

    public Users create(Users users) {
        Assert.notNull(users, "user must not be null");
        return users;
    }

    public void delete(int id) {
        checkNotFoundWithId(repository.delete(id), id);
    }

    public Users get(int id) {
        return checkNotFoundWithId(repository.get(id), id);
    }

    public Users getByEmail(String email) {
        Assert.notNull(email, "email must not be null");
        return checkNotFound(repository.getByEmail(email), "email=" + email);
    }

    public List<Users> getAll() {
        return repository.getAll();
    }

    @Transactional
    public void enable(int id, boolean enabled) {
        Users users = get(id);
        users.setEnabled(enabled);
    }

    public void update(Users users) {
        Assert.notNull(repository.save(users), "user must not be null");
    }

}
