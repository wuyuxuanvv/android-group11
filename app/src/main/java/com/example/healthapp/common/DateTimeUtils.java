package com.example.healthapp.common;

import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;

/** Shared date rules: dates use yyyy-MM-dd and date-times use epoch milliseconds. */
public final class DateTimeUtils {
    public static final DateTimeFormatter DATE_FORMATTER = DateTimeFormatter.ISO_LOCAL_DATE;

    private DateTimeUtils() {
    }

    public static String today() {
        return formatDate(LocalDate.now());
    }

    public static String formatDate(LocalDate date) {
        return DATE_FORMATTER.format(date);
    }

    public static LocalDate parseDate(String date) throws DateTimeParseException {
        return LocalDate.parse(date, DATE_FORMATTER);
    }

    public static String dateFromEpochMillis(long epochMillis) {
        return formatDate(Instant.ofEpochMilli(epochMillis)
                .atZone(ZoneId.systemDefault())
                .toLocalDate());
    }

    public static int calculateDurationMinutes(long startEpochMillis, long endEpochMillis) {
        if (endEpochMillis <= startEpochMillis) {
            throw new IllegalArgumentException("Wake time must be after sleep time");
        }
        long minutes = ChronoUnit.MINUTES.between(
                Instant.ofEpochMilli(startEpochMillis),
                Instant.ofEpochMilli(endEpochMillis));
        if (minutes > Integer.MAX_VALUE) {
            throw new IllegalArgumentException("Duration is too large");
        }
        return (int) minutes;
    }

    public static List<String> datesBetweenInclusive(String startDate, String endDate) {
        LocalDate start = parseDate(startDate);
        LocalDate end = parseDate(endDate);
        if (end.isBefore(start)) {
            throw new IllegalArgumentException("End date must not be before start date");
        }
        List<String> dates = new ArrayList<>();
        for (LocalDate date = start; !date.isAfter(end); date = date.plusDays(1)) {
            dates.add(formatDate(date));
        }
        return dates;
    }
}
