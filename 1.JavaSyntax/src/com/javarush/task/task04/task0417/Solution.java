package com.javarush.task.task04.task0417;

/* 
Существует ли пара?
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws Exception {
        InputStream inputStream = System.in;
        Reader inputStreamReader = new InputStreamReader(inputStream);
        BufferedReader bufferedReader = new BufferedReader(inputStreamReader);

        String s1 = bufferedReader.readLine(); //читаем строку с клавиатуры
        String s2 = bufferedReader.readLine(); //читаем строку с клавиатуры
        String s3 = bufferedReader.readLine(); //читаем строку с клавиатуры
        int a = Integer.parseInt(s1); //преобразовываем строку в число.
        int b = Integer.parseInt(s2); //преобразовываем строку в число.
        int c = Integer.parseInt(s3); //преобразовываем строку в число.

        if ((a==b) && (b==c)) System.out.println(a+" "+b+" "+c);
        else if (a==b) System.out.println(a+" "+b);
        else if (c==b) System.out.println(b+" "+c);
        else if (a==c) System.out.println(a+" "+c);

    }
}