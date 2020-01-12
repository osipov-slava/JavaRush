package com.javarush.task.task40.task4008;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoField;

import static java.time.temporal.ChronoField.AMPM_OF_DAY;

/* 
Работа с Java 8 DateTime API
*/

public class Solution {
    public static void main(String[] args) {
        printDate("9.10.2017 5:56:45");
        System.out.println();
        printDate("21.4.2014");
        System.out.println();
        printDate("17:33:40");
    }

    public static void printDate(String date) {
        if (date.matches("\\d{1,2}\\.\\d{1,2}\\.\\d{4}")) {
            printOnlyDate(date);
        }
        if (date.matches("\\d{1,2}:\\d{1,2}:\\d{1,2}")) {
            printOnlyTime(date);
        }
        if (date.matches("\\d{1,2}\\.\\d{1,2}\\.\\d{4} \\d{1,2}:\\d{1,2}:\\d{1,2}")) {
            String[] strings = date.split(" ");
            printOnlyDate(strings[0]);
            printOnlyTime(strings[1]);
        }
    }

    private static void printOnlyDate(String data) {
        DateTimeFormatter formatter;
        LocalDate localDate;
        formatter = DateTimeFormatter.ofPattern("d.M.yyyy");
        localDate = LocalDate.parse(data, formatter);

        System.out.println("День: " + localDate.get(ChronoField.DAY_OF_MONTH));
        System.out.println("День недели: " + localDate.get(ChronoField.DAY_OF_WEEK));
        System.out.println("День месяца: " +localDate.get(ChronoField.DAY_OF_MONTH));
        System.out.println("День года: " + localDate.get(ChronoField.DAY_OF_YEAR));
        System.out.println("Неделя месяца: " + localDate.get(ChronoField.ALIGNED_WEEK_OF_MONTH));
        System.out.println("Неделя года: " + localDate.get(ChronoField.ALIGNED_WEEK_OF_YEAR));
        System.out.println("Месяц: " + localDate.get(ChronoField.MONTH_OF_YEAR));
        System.out.println("Год: " + localDate.get(ChronoField.YEAR));
    }

    private static void printOnlyTime(String data) {
        DateTimeFormatter formatter;
        LocalTime localTime;
        formatter = DateTimeFormatter.ofPattern("H:m:s");
        localTime = LocalTime.parse(data, formatter);


        if (localTime.get(ChronoField.AMPM_OF_DAY) == 0) System.out.println("AM или PM: AM");
        else System.out.println("AM или PM: PM");
        System.out.println("Часы: " + localTime.get(ChronoField.CLOCK_HOUR_OF_AMPM));
        System.out.println("Часы дня: " + localTime.get(ChronoField.HOUR_OF_DAY));
        System.out.println("Минуты: " + localTime.get(ChronoField.MINUTE_OF_HOUR));
        System.out.println("Секунды: " + localTime.get(ChronoField.SECOND_OF_MINUTE));
    }


}
