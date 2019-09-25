package com.javarush.task.task18.task1807;

/* 
Подсчет запятых
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
        FileInputStream inputStream = new FileInputStream(file);

        byte[] buffer = null;
        if (inputStream.available() > 0) {
            //читаем весь файл одним куском
            buffer = new byte[inputStream.available()];
            int count = inputStream.read(buffer);

        }

        int j = 0;
        if (buffer!=null) {
            for (int i = 0; i < buffer.length; i++) {
                if (buffer[i] == 0x2c) j++;
            }
        }
        inputStream.close();
        System.out.println(j);


    }
}
