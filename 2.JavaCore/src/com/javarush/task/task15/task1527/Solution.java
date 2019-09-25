package com.javarush.task.task15.task1527;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

/* 
Парсер реквестов
*/

public class Solution {
    public static void main(String[] args) {

        String str = null;
        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            str = reader.readLine();
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        String[] strings = null;

        if (!str.equals("")) {
            strings = readParametersFromString (str);
        }

        //вывести на экран параметры

        for (int i = 0; i < strings.length ; i++) {
            int a = strings[i].indexOf("=");
            if (a == -1) {
                System.out.print(strings[i]);
                if (i != strings.length - 1) System.out.print(" ");
                continue;
            }
            String paramValue = strings[i].substring(0,a);
            System.out.print(paramValue);
            if (i != strings.length - 1) System.out.print(" ");

        }
        System.out.println("");

        for (String str2: strings) {

            if (str2.indexOf("obj")!=-1) {
                try {
                    str2 = str2.substring(4);
                    double d = Double.parseDouble(str2);
                    alert(d);
                    continue;
                } catch (NumberFormatException e) {}

                alert(str2);
            }
        }
    }

    public static void alert(double value) {
        System.out.println("double: " + value);
    }

    public static void alert(String value) {
        System.out.println("String: " + value);
    }

    public static String [] readParametersFromString(String s){

        int i = s.indexOf("?");
        s = s.substring(i+1);
        String [] strings = s.split("&");
        return strings;
    }
}
