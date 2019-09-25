package com.javarush.task.task08.task0827;

import java.util.Date;

/* 
Работа с датой
*/

public class Solution {
    public static void main(String[] args) {

        System.out.println(isDateOdd("JANUARY 1 2013"));
        System.out.println(isDateOdd("JANUARY 2 2013"));
        System.out.println(isDateOdd("JANUARY 31 2013"));
        System.out.println(isDateOdd("FEBRUARY 1 2013"));
        //System.out.println(isDateOdd("MAY 1 2013"));

    }

    public static boolean isDateOdd(String date) {
        Date date1=new Date(date);
        Date beginYear= new Date(date);
        beginYear.setYear(date1.getYear());
        beginYear.setMonth(0);
        beginYear.setDate(1);
        beginYear.setHours(0);


        //System.out.println(beginYear);
        //System.out.println(date1);
        long timeForYear=date1.getTime()-beginYear.getTime();
        long dayL = timeForYear /1000/60/60/24;
        int day = (int) dayL+1;
        //System.out.println(day+1);
        return (!(day%2==0));
    }
}
