package com.javarush.task.task04.task0422;

/* 
18+
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws Exception {
        InputStream inputStream = System.in;
        Reader inputStreamReader = new InputStreamReader(inputStream);
        BufferedReader bufferedReader = new BufferedReader(inputStreamReader);

        String name = bufferedReader.readLine(); //читаем строку с клавиатуры
        String age = bufferedReader.readLine(); //читаем строку с клавиатуры
        int a = Integer.parseInt(age); //преобразовываем строку в число.

        if (a<18) System.out.println("Подрасти еще");
//напишите тут ваш код
    }
}
