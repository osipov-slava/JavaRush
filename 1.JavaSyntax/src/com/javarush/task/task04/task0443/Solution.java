package com.javarush.task.task04.task0443;


/* 
Как назвали, так назвали
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws Exception {
        InputStream inputStream = System.in;
        Reader inputStreamReader = new InputStreamReader(inputStream);
        BufferedReader bufferedReader = new BufferedReader(inputStreamReader);

        String name = bufferedReader.readLine(); //читаем строку с клавиатуры
        String s1 = bufferedReader.readLine(); //читаем строку с клавиатуры
        String s2 = bufferedReader.readLine(); //читаем строку с клавиатуры
        String s3 = bufferedReader.readLine(); //читаем строку с клавиатуры
        int y = Integer.parseInt(s1); //преобразовываем строку в число.
        int m = Integer.parseInt(s2); //преобразовываем строку в число.
        int d = Integer.parseInt(s3); //преобразовываем строку в число.

        System.out.println("Меня зовут "+name+".");
        System.out.println("Я родился "+d+"."+m+"."+y);

    }
}
