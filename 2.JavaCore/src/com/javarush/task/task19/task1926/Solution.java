package com.javarush.task.task19.task1926;

/* 
Перевертыши
*/

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) throws IOException{
        BufferedReader readerConsole = new BufferedReader(new InputStreamReader(System.in));
        String fileIn = readerConsole.readLine();
        readerConsole.close();

        BufferedReader readerFile = new BufferedReader(new FileReader(fileIn));
        while (readerFile.ready()) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(readerFile.readLine());
            stringBuilder.reverse();
            System.out.println(stringBuilder);
        }
        readerFile.close();
    }
}
