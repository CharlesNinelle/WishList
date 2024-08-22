package com.example.wishlist.util;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class DateUtils {

    private static final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");

    public static String formatDate(LocalDate date) {
        return date.format(formatter);
    }

    public static LocalDate parseDate(String dateString) {
        return LocalDate.parse(dateString, formatter);
    }

    public static LocalDate getCurrentDate() {
        return LocalDate.now();
    }
}
