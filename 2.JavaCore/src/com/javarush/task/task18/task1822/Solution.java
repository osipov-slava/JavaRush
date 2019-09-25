package com.javarush.task.task18.task1822;

/* 
Поиск данных внутри файла
*/

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) throws IOException{
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String file = reader.readLine();
        reader.close();

        FileInputStream fileInputStream = new FileInputStream(file);
        InputStreamReader inputStreamReader = new InputStreamReader(fileInputStream);
        BufferedReader readerFile = new BufferedReader(inputStreamReader);

        String strLine;
        int i = 0;
        while ((strLine = readerFile.readLine()) != null){
            if (strLine.startsWith(args[0] + " ")) System.out.println(strLine);
        }

        readerFile.close();

    }
}
