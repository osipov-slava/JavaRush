package com.javarush.task.task18.task1816;

/* 
Английские буквы
*/

import java.io.FileInputStream;
import java.io.IOException;

public class Solution {
    public static void main(String[] args) throws IOException{
        FileInputStream inputStream = new FileInputStream(args[0]);

        int countEng = 0;
        if (inputStream.available() > 0) {
            //читаем весь файл одним куском
            byte[] buffer = new byte[inputStream.available()];
            int count = inputStream.read(buffer);
            for (int i = 0; i < buffer.length; i++) {
                if ((buffer[i] >= 'a' && buffer[i] <= 'z') ||
                        (buffer[i] >= 'A' && buffer[i] <= 'Z'))
                            countEng++;
            }
            System.out.println(countEng);
        }

        inputStream.close();

    }
}
