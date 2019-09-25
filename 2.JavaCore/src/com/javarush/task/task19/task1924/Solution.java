package com.javarush.task.task19.task1924;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* 
Замена чисел
*/

public class Solution {
    public static Map<Integer, String> map = new HashMap<Integer, String>();

    static {
        map.put(0, "ноль");
        map.put(1, "один");
        map.put(2, "два");
        map.put(3, "три");
        map.put(4, "четыре");
        map.put(5, "пять");
        map.put(6, "шесть");
        map.put(7, "семь");
        map.put(8, "восемь");
        map.put(9, "девять");
        map.put(10, "десять");
        map.put(11, "одиннадцать");
        map.put(12, "двенадцать");
    }

    public static void main(String[] args) throws IOException{
        BufferedReader readerConsole = new BufferedReader(new InputStreamReader(System.in));
        String fileIn = readerConsole.readLine();
        readerConsole.close();

        BufferedReader readerFile = new BufferedReader(new FileReader(fileIn));
        while (readerFile.ready()) {
            String str = readerFile.readLine();
            Pattern pattern = Pattern.compile("\\b\\d+\\b");
            Matcher matcher = pattern.matcher(str);
            int nextPos = 0;
            while (matcher.find()) {
                System.out.print(str.substring(nextPos, matcher.start()));//вывод до встречи числа
                int a = Integer.parseInt(str.substring(matcher.start(),matcher.end()));
                if (a <= 12) {
                    System.out.print(map.get(a));// вывод числа прописью если оно до 13
                }
                else System.out.print(str.substring(matcher.start(),matcher.end()));//вывод числа как есть в ином случае
                nextPos = matcher.end();// переносим отчет в конец уже выведенного текста.
            }
            System.out.println(str.substring(nextPos,str.length()));// вывод остатка строки
        }
        readerFile.close();
    }
}
