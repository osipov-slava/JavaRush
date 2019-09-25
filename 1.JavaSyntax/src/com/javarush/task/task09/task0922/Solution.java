package com.javarush.task.task09.task0922;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

/* 
Какое сегодня число?
*/

public class Solution {

    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String string=reader.readLine(); //преобразовываем строку в число.
        SimpleDateFormat oldDateFormat = new SimpleDateFormat("MM/dd/yyyy",Locale.ENGLISH);
        SimpleDateFormat newDateFormat = new SimpleDateFormat("MMM dd, yyyy",Locale.ENGLISH);

        Date date = oldDateFormat.parse(string);
        string = newDateFormat.format(date);
        System.out.println(string.toUpperCase());




/*

        String oldDateString = "2015-05-15";
        SimpleDateFormat oldDateFormat = new SimpleDateFormat("yyyy-MM-dd", Locale.getDefault());
        SimpleDateFormat newDateFormat = new SimpleDateFormat("dd MMMM yyyy", Locale.getDefault());

        Date date = oldDateFormat.parse(oldDateString);
        String result = newDateFormat.format(date);*/
    }
}
