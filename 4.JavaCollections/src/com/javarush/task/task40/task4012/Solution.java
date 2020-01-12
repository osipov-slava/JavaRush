package com.javarush.task.task40.task4012;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Period;
import java.time.temporal.ChronoField;
import java.time.temporal.ChronoUnit;

/* 
Полезные методы DateTime API
*/

public class Solution {
    public static void main(String[] args) {
        LocalDate firstDate = LocalDate.now();
        LocalDate secondDate = firstDate.plusMonths(6);
        LocalDateTime dateTime = LocalDateTime.now().minusDays(1);
        LocalTime time = LocalTime.now();
        ChronoUnit chronoUnit = ChronoUnit.HOURS;

        System.out.println(isLeap(firstDate));
        System.out.println(isBefore(dateTime));
        System.out.println(addTime(time, 6 , chronoUnit).get(ChronoField.HOUR_OF_DAY));
        System.out.println(getPeriodBetween(firstDate,secondDate).getMonths());

    }

    public static boolean isLeap(LocalDate date) {
        return date.isLeapYear();
    }

    public static boolean isBefore(LocalDateTime dateTime) {
        return dateTime.isBefore(LocalDateTime.now());
    }

    public static LocalTime addTime(LocalTime time, int n, ChronoUnit chronoUnit) {
        return time.plus(n, chronoUnit);
    }

    public static Period getPeriodBetween(LocalDate firstDate, LocalDate secondDate) {
        if (firstDate.isBefore(secondDate)) return firstDate.until(secondDate);
        else return secondDate.until(firstDate);
    }
}
