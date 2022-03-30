package ru.kosmos.restaurantratingsystem.web;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import ru.kosmos.restaurantratingsystem.AuthorizedUser;

import static java.util.Objects.requireNonNull;

public class SecurityUtil {

    private SecurityUtil() {
    }

    public static AuthorizedUser safeGet() {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        if (auth == null) {
            return null;
        }
        Object principal = auth.getPrincipal();
        return (principal instanceof AuthorizedUser) ? (AuthorizedUser) principal : null;
    }

    public static AuthorizedUser get() {
        return requireNonNull(safeGet(), "No authorized user found");
    }

    public static int authUserId() {
        return get().getUsersDto().id();
    }

}