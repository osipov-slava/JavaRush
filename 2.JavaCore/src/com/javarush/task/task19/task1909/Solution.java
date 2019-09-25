package com.javarush.task.task19.task1909;

/* 
Замена знаков
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader readerConsole = new BufferedReader(new InputStreamReader(System.in));
        String fileIn = readerConsole.readLine();
        String fileOut = readerConsole.readLine();
        readerConsole.close();

        BufferedReader reader = new BufferedReader(new FileReader(fileIn));
        BufferedWriter writer = new BufferedWriter(new FileWriter(fileOut));

        while (reader.ready()) //пока есть непрочитанные байты в потоке ввода
        {
            int i = reader.read();
            if ((char)i == '.') i = (int) '!';
            writer.write(i);
        }

        reader.close();
        writer.close();
    }
}
