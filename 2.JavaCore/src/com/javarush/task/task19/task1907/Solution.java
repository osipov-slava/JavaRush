package com.javarush.task.task19.task1907;

/* 
Считаем слово
*/

import java.io.*;
import java.util.ArrayList;

public class Solution {
    public static void main(String[] args) throws IOException{
        BufferedReader readerConsole = new BufferedReader(new InputStreamReader(System.in));
        String fileIn = readerConsole.readLine();
        readerConsole.close();

        FileReader reader = new FileReader(fileIn);

        String stringFile = "";
        while (reader.ready()) //пока есть непрочитанные байты в потоке ввода
        {
            stringFile+=((char)reader.read());
        }
        reader.close();

        String[] strings = stringFile.split("\\W");
        int i = 0;
        for (String s:strings) {
            if (s.equals("world")) i++;
        }
        System.out.println(i);


    }
}
