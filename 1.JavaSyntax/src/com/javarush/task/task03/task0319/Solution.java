package com.javarush.task.task03.task0319;

/* 
Предсказание на будущее
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws Exception {
        InputStream inputStream = System.in;
        Reader inputStreamReader = new InputStreamReader(inputStream);
        BufferedReader bufferedReader = new BufferedReader(inputStreamReader);

        String name = bufferedReader.readLine(); //читаем строку с клавиатуры
        String sZp = bufferedReader.readLine();
        String sAge = bufferedReader.readLine();

        //читаем строку с клавиатуры
        int nAge = Integer.parseInt(sAge);
        int nZp = Integer.parseInt(sZp);

        System.out.println(name + " получает "+ nZp + " через " + nAge + " лет.");
        //преобразовываем строку в число.
        // напишите тут ваш код
    }
}
