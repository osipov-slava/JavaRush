package com.javarush.task.task05.task0528;
import java.util.GregorianCalendar;
/* 
Вывести на экран сегодняшнюю дату
*/

public class Solution {
    public static void main(String[] args) {
        GregorianCalendar calendar = new GregorianCalendar();
        calendar.getInstance();

        System.out.println("" + calendar.get(calendar.DAY_OF_MONTH) + " " + (calendar.get(calendar.MONTH)+1)
                + " " + calendar.get(calendar.YEAR));
    }
}
