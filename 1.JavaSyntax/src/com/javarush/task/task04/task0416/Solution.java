package com.javarush.task.task04.task0416;

/* 
Переходим дорогу вслепую
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws Exception {
        InputStream inputStream = System.in;
        Reader inputStreamReader = new InputStreamReader(inputStream);
        BufferedReader bufferedReader = new BufferedReader(inputStreamReader);

        String sAge = bufferedReader.readLine(); //читаем строку с клавиатуры
        double a = Double.parseDouble(sAge); //преобразовываем строку в число.

        a=a%5;
        if ((a>=0) && (a<3)) System.out.println("зелёный");
        else if ((a>=3) && (a<4)) System.out.println("жёлтый");
        else System.out.println("красный");
    }
}