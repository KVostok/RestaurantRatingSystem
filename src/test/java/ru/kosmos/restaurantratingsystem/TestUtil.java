package ru.kosmos.restaurantratingsystem;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors;
import org.springframework.test.web.servlet.request.RequestPostProcessor;
import ru.kosmos.restaurantratingsystem.model.Users;

public class TestUtil {

    public static void mockAuthorize(Users users) {
        SecurityContextHolder.getContext().setAuthentication(
                new UsernamePasswordAuthenticationToken(new AuthorizedUser(users), null, users.getRoles()));
    }

    public static RequestPostProcessor userHttpBasic(Users users) {
        return SecurityMockMvcRequestPostProcessors.httpBasic(users.getEmail(), users.getPassword());
    }

    public static RequestPostProcessor userAuth(Users users) {
        return SecurityMockMvcRequestPostProcessors.authentication(new UsernamePasswordAuthenticationToken(users.getEmail(), users.getPassword()));
    }

}
