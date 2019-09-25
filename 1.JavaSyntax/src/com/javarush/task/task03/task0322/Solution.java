package com.javarush.task.task03.task0322;


/* 
Большая и чистая
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws Exception {
        InputStream inputStream = System.in;
        Reader inputStreamReader = new InputStreamReader(inputStream);
        BufferedReader bufferedReader = new BufferedReader(inputStreamReader);

        String name1 = bufferedReader.readLine(); //читаем строку с клавиатуры
        String name2 = bufferedReader.readLine(); //читаем строку с клавиатуры
        String name3 = bufferedReader.readLine(); //читаем строку с клавиатуры

        System.out.println(name1+" + "+name2+" + "+name3+" = Чистая любовь, да-да!");
        // напишите тут ваш код
    }
}