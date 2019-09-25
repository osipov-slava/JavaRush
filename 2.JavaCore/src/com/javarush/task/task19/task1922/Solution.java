package com.javarush.task.task19.task1922;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.regex.Pattern;

/* 
Ищем нужные строки
*/

public class Solution {
    public static List<String> words = new ArrayList<String>();

    static {
        words.add("файл");
        words.add("вид");
        words.add("В");
    }

    public static void main(String[] args) throws IOException{
        BufferedReader readerConsole = new BufferedReader(new InputStreamReader(System.in));
        String fileIn = readerConsole.readLine();
        readerConsole.close();

        BufferedReader readerFile = new BufferedReader(new FileReader(fileIn));
        while (readerFile.ready()) {
            String str = readerFile.readLine();
            String [] strings = str.split("\\s");
            int a=0;
            for (int i = 0; i < strings.length; i++) {
                for (String s: words) {
                    if (s.equals(strings[i])) a++;
                }
            }
            if (a==2) System.out.println(str);
        }
        readerFile.close();

    }
}
