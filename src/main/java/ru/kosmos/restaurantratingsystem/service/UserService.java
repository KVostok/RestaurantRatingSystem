package ru.kosmos.restaurantratingsystem.service;

import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;
import ru.kosmos.restaurantratingsystem.AuthorizedUser;
import ru.kosmos.restaurantratingsystem.dto.UsersDTO;
import ru.kosmos.restaurantratingsystem.model.Users;
import ru.kosmos.restaurantratingsystem.repository.UserRepository;
import ru.kosmos.restaurantratingsystem.util.UsersUtil;

import java.util.List;

import static ru.kosmos.restaurantratingsystem.util.UsersUtil.prepareToSave;
import static ru.kosmos.restaurantratingsystem.util.validation.ValidationUtil.checkNotFound;
import static ru.kosmos.restaurantratingsystem.util.validation.ValidationUtil.checkNotFoundWithId;

@Service("userService")
@Scope(proxyMode = ScopedProxyMode.TARGET_CLASS)
public class UserService implements UserDetailsService {

    private final UserRepository repository;
    private final PasswordEncoder passwordEncoder;

    public UserService(UserRepository repository, PasswordEncoder passwordEncoder) {
        this.repository = repository;
        this.passwordEncoder = passwordEncoder;
    }

    public Users create(Users users) {
        Assert.notNull(users, "user must not be null");
        return prepareAndSave(users);
    }

    public void delete(int id) {
        checkNotFoundWithId(repository.delete(id), id);
    }

    public Users get(int id) {
        return checkNotFoundWithId(repository.get(id), id);
    }

    public Users getByIdWithRoles(int id) {
        return checkNotFoundWithId(repository.getByIdWithRoles(id), id);
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
        Assert.notNull(users, "user must not be null");
        prepareAndSave(users);
    }

    @Transactional
    public void update(UsersDTO usersDto) {
        Users users = get(usersDto.id());
        prepareAndSave(UsersUtil.updateFromTo(users, usersDto));
    }

    @Override
    public AuthorizedUser loadUserByUsername(String email) throws UsernameNotFoundException {
        Users users = repository.getByEmail(email.toLowerCase());
        if (users == null) {
            throw new UsernameNotFoundException("User " + email + " is not found");
        }
        return new AuthorizedUser(users);
    }

    private Users prepareAndSave(Users users) {
        return repository.save(prepareToSave(users, passwordEncoder));
    }

}
