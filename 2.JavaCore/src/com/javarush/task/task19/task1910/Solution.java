package com.javarush.task.task19.task1910;

/* 
Пунктуация
*/

import java.io.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Solution {
    public static void main(String[] args) throws IOException{
        BufferedReader readerConsole = new BufferedReader(new InputStreamReader(System.in));
        String fileIn = readerConsole.readLine();
        String fileOut = readerConsole.readLine();
        readerConsole.close();

        BufferedReader reader = new BufferedReader(new FileReader(fileIn));
        BufferedWriter writer = new BufferedWriter(new FileWriter(fileOut));

        String s = "";
        while (reader.ready()) //пока есть непрочитанные байты в потоке ввода
        {
            s += (char) reader.read();
        }

        //s.replaceAll("\\p{P}","");
        Pattern pattern = Pattern.compile("\\p{Punct}|\\n");
        Matcher m = pattern.matcher(s);
        String s1 = m.replaceAll("");

        writer.write(s1);

        reader.close();
        writer.close();
    }
}
