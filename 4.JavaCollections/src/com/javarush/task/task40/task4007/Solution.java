package com.javarush.task.task40.task4007;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

/* 
Работа с датами
*/

public class Solution {
    public static void main(String[] args) {
//        printDate("21.4.2014 15:56:45");
//        System.out.println();
        printDate("13.01.2020");
        System.out.println();
        printDate("17:33:40");
    }

    public static void printDate(String date) {
        String pattern = "";
        if (date.matches("\\d{1,2}\\.\\d{1,2}\\.\\d{4}")) {
            printDate(getCalendar(date, "dd.MM.yyyy"));
        }
        if (date.matches("\\d{1,2}:\\d{1,2}:\\d{1,2}")) {
            printTime(getCalendar(date, "HH:mm:ss"));
        }
        if (date.matches("\\d{1,2}\\.\\d{1,2}\\.\\d{4} \\d{1,2}:\\d{1,2}:\\d{1,2}")) {
            Calendar calendar = getCalendar(date, "dd.MM.yyyy HH:mm:ss");
            printDate(calendar);
            printTime(calendar);
        }
    }

    private static Calendar getCalendar(String date, String pattern) {
        SimpleDateFormat format = new SimpleDateFormat(pattern);
        Calendar calendar = Calendar.getInstance();
        try {
            Date date1 = format.parse(date);
            calendar.setTime(date1);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return calendar;
    }

    private static void printDate(Calendar calendar) {
        System.out.println("День: " + calendar.get(Calendar.DATE));
        if (calendar.get(Calendar.DAY_OF_WEEK) == 1) System.out.println("День недели: 7");
        else System.out.println("День недели: " + (calendar.get(Calendar.DAY_OF_WEEK)-1));
        System.out.println("День месяца: " + calendar.get(Calendar.DAY_OF_MONTH));
        System.out.println("День года: " + calendar.get(Calendar.DAY_OF_YEAR));
        System.out.println("Неделя месяца: " + calendar.get(Calendar.WEEK_OF_MONTH));
        System.out.println("Неделя года: " + calendar.get(Calendar.WEEK_OF_YEAR));
        System.out.println("Месяц: " + (calendar.get(Calendar.MONTH) + 1));
        System.out.println("Год: " + calendar.get(Calendar.YEAR));
    }

    private static void printTime(Calendar calendar) {
        if (calendar.get(Calendar.AM_PM) == 0) System.out.println("AM или PM: AM");
        else System.out.println("AM или PM: PM");
        System.out.println("Часы: " + calendar.get(Calendar.HOUR));
        System.out.println("Часы дня: " + calendar.get(Calendar.HOUR_OF_DAY));
        System.out.println("Минуты: " + calendar.get(Calendar.MINUTE));
        System.out.println("Секунды: " + calendar.get(Calendar.SECOND));
    }
}
