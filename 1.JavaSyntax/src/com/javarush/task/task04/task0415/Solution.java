package com.javarush.task.task04.task0415;

/* 
Правило треугольника
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws Exception {
        InputStream inputStream = System.in;
        Reader inputStreamReader = new InputStreamReader(inputStream);
        BufferedReader bufferedReader = new BufferedReader(inputStreamReader);

        String s1 = bufferedReader.readLine(); //читаем строку с клавиатуры
        String s2 = bufferedReader.readLine(); //читаем строку // с клавиатуры
        String s3 = bufferedReader.readLine(); //читаем строку с клавиатуры
        int a = Integer.parseInt(s1); //преобразовываем строку в число.
        int b = Integer.parseInt(s2); //преобразовываем строку в число.
        int c = Integer.parseInt(s3);//преобразовываем строку в число.

        if ((a<(b+c)) && (b<(a+c)) && (c<(b+a))) System.out.println("Треугольник существует.");
        else System.out.println("Треугольник не существует.");
    }
}