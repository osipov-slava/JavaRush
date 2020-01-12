package com.javarush.task.task40.task4009;

import java.time.LocalDate;
import java.time.Year;
import java.time.format.DateTimeFormatter;
import java.time.format.TextStyle;
import java.util.Locale;

/* 
Buon Compleanno!
*/

public class Solution {
    public static void main(String[] args) {

        System.out.println(getWeekdayOfBirthday("30.05.1984", "2015"));
    }

    public static String getWeekdayOfBirthday(String birthday, String year) {
        DateTimeFormatter formatter;

        formatter = DateTimeFormatter.ofPattern("d.M.yyyy");
        LocalDate birthdayDate = LocalDate.parse(birthday, formatter);

        formatter = DateTimeFormatter.ofPattern("yyyy");
        LocalDate findDate = birthdayDate.withYear(Year.parse(year).getValue());
        return findDate.getDayOfWeek().getDisplayName(TextStyle.FULL, Locale.ITALIAN);
    }
}
