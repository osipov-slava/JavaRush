package com.javarush.task.task04.task0424;

/* 
Три числа
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
        int a1 = Integer.parseInt(s1); //преобразовываем строку в число.
        int a2 = Integer.parseInt(s2); //преобразовываем строку в число.
        int a3 = Integer.parseInt(s3); //преобразовываем строку в число.
        int b=0;

        if ((a1!=a2) && (a2==a3)) b=1;
        if ((a2!=a1) && (a1==a3)) b=2;
        if ((a3!=a1) && (a1==a2)) b=3;

        if (b>0) System.out.println(b);


//напишите тут ваш код
    }
}
