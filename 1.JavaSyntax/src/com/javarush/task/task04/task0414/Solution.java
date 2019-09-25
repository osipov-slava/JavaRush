package com.javarush.task.task04.task0414;

/* 
Количество дней в году
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws Exception {
        InputStream inputStream = System.in;
        Reader inputStreamReader = new InputStreamReader(inputStream);
        BufferedReader bufferedReader = new BufferedReader(inputStreamReader);

        String sAge = bufferedReader.readLine(); //читаем строку с клавиатуры
        int a = Integer.parseInt(sAge); //преобразовываем строку в число.

        boolean visok=false;

        if (a%400==0) visok=true;
        else if (a%100==0) visok=false;
        else if (a%4==0) visok=true;
        else visok=false;

        if (visok==true) System.out.println("количество дней в году: 366");
        else System.out.println("количество дней в году: 365");
    }
}