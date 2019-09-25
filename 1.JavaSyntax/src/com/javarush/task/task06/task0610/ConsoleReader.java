package com.javarush.task.task06.task0610;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/* 
Класс ConsoleReader
*/

public class ConsoleReader {
    public static String readString() throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        return reader.readLine(); //читаем строку с клавиатуры
    }

    public static int readInt() throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String s1 = reader.readLine(); //читаем строку с клавиатуры
        return Integer.parseInt(s1);

    }

    public static double readDouble() throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String s1 = reader.readLine(); //читаем строку с клавиатуры
        return Double.parseDouble(s1);
    }

    public static boolean readBoolean() throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String s1 = reader.readLine(); //читаем строку с клавиатуры
        return Boolean.parseBoolean(s1);//напишите тут ваш код

    }

    public static void main(String[] args) {

    }
}
