package ru.kosmos.restaurantratingsystem.repository;

import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Repository;
import ru.kosmos.restaurantratingsystem.model.Users;

import java.util.List;

@Repository
public class UserRepository {
    private static final Sort SORT_NAME_EMAIL = Sort.by(Sort.Direction.ASC, "name", "email");
    private final CrudUserRepository repository;

    public UserRepository(CrudUserRepository repository) {
        this.repository = repository;
    }

    public Users save(Users user) {
        return repository.save(user);
    }

    public boolean delete(int id) {
        return repository.delete(id) != 0;
    }

    public Users get(int id) {
        return repository.findById(id).orElse(null);
    }

    public Users getByEmail(String email) {
        return repository.getByEmail(email);
    }

    public List<Users> getAll() {
        return repository.findAll(SORT_NAME_EMAIL);
    }

}
