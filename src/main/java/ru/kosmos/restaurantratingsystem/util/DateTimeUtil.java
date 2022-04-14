package ru.kosmos.restaurantratingsystem.util;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class DateTimeUtil {

    public static final String DATE_TIME_PATTERN = "HH-mm";
    public static final DateTimeFormatter DATE_TIME_FORMATTER = DateTimeFormatter.ofPattern(DATE_TIME_PATTERN);

    private DateTimeUtil() {
    }

    public static String toString(LocalTime lt) {
        return lt == null ? "" : lt.format(DATE_TIME_FORMATTER);
    }

}
