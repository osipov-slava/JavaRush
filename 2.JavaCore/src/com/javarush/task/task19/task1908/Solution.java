package com.javarush.task.task19.task1908;

/* 
Выделяем числа
*/

import java.io.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader readerConsole = new BufferedReader(new InputStreamReader(System.in));
        String fileIn = readerConsole.readLine();
        String fileOut = readerConsole.readLine();
        readerConsole.close();

        BufferedReader reader = new BufferedReader(new FileReader(fileIn));
        BufferedWriter writer = new BufferedWriter(new FileWriter(fileOut));

        String stringFile = "";
        while (reader.ready()) //пока есть непрочитанные байты в потоке ввода
        {
            stringFile+=((char)reader.read());
        }
        reader.close();

        String[] s = stringFile.split(" ");

        for (int i = 0 ; i < s.length; i++) {
            if (Pattern.matches("\\d+",s[i]))
                writer.write(s[i]+" ");
        }

        writer.close();
    }
}
