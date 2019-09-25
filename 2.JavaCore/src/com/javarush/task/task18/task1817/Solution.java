package com.javarush.task.task18.task1817;

/* 
Пробелы
*/

import java.io.FileInputStream;
import java.io.IOException;

public class Solution {
    public static void main(String[] args) throws IOException{
        FileInputStream inputStream = new FileInputStream(args[0]);


        if (inputStream.available() > 0) {
            //читаем весь файл одним куском
            byte[] buffer = new byte[inputStream.available()];
            double count = inputStream.read(buffer);
            double space = 0;

            for (int i = 0; i < buffer.length; i++) {
                if (buffer[i] == ' ') space++;
            }
            System.out.printf("%.2f",(space / count * 100));
        }

        inputStream.close();
    }
}
