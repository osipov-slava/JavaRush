package com.javarush.task.task19.task1906;

/* 
Четные символы
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException{
        BufferedReader readerConsole = new BufferedReader(new InputStreamReader(System.in));
        String fileIn = readerConsole.readLine();
        String fileOut = readerConsole.readLine();
        readerConsole.close();

        FileReader reader = new FileReader(fileIn);
        FileWriter writer = new FileWriter(fileOut);

        while (reader.ready()) //пока есть непрочитанные байты в потоке ввода
        {
            int data = reader.read();
            data = reader.read();
            writer.write(data);
        }

        reader.close();
        writer.close();

    }
}
