package com.cbs.edu.examples.cw_09;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.Period;
import java.time.chrono.Era;
import java.time.format.DateTimeFormatter;

import static java.time.temporal.ChronoUnit.DAYS;

public class LocalDateExample {
    public static void main(String[] args) {
        LocalDate now = LocalDate.now();
        System.out.println(now);

        DayOfWeek dayOfWeek = now.getDayOfWeek();
        System.out.println(dayOfWeek);

        System.out.println(now.getDayOfYear());
        Era era = now.getEra();
        System.out.println(era);

        LocalDate of = LocalDate.of(1992, 12, 26);
        System.out.println(of);
        System.out.println(of.getMonth());

        System.out.println(now.isAfter(of));
        System.out.println(now.isBefore(of));

        long between = DAYS.between(of, now);
        System.out.println(between);

        LocalDate fromIsoDate = LocalDate.parse("2014-01-20");
        LocalDate fromCustomPattern = LocalDate.parse("200.01.2014", DateTimeFormatter.ofPattern("dd.MM.yyyy"));
        System.out.println(fromCustomPattern);
    }
}
