package ru.kosmos.restaurantratingsystem.util;

import org.springframework.core.NestedExceptionUtils;
import org.springframework.lang.NonNull;

public class ValidationUtil {
    //  https://stackoverflow.com/a/65442410/548473
    @NonNull
    public static Throwable getRootCause(@NonNull Throwable t) {
        Throwable rootCause = NestedExceptionUtils.getRootCause(t);
        return rootCause != null ? rootCause : t;
    }
}
