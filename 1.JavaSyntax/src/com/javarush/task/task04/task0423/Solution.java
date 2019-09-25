package com.javarush.task.task04.task0423;

/* 
Фейс-контроль
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws Exception {
        InputStream inputStream = System.in;
        Reader inputStreamReader = new InputStreamReader(inputStream);
        BufferedReader bufferedReader = new BufferedReader(inputStreamReader);

        String name = bufferedReader.readLine(); //читаем строку с клавиатуры
        String s1 = bufferedReader.readLine(); //читаем строку с клавиатуры
        int a = Integer.parseInt(s1); //преобразовываем строку в число.

        if (a>20) System.out.println("И 18-ти достаточно");
//напишите тут ваш код
    }
}
