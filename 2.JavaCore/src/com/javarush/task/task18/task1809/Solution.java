package com.javarush.task.task18.task1809;

/* 
Реверс файла
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String file1 = reader.readLine();
        String file2 = reader.readLine();
        reader.close();

        FileInputStream inputStream = new FileInputStream(file1);
// Создаем поток-записи-байт-в-файл
        FileOutputStream outputStream = new FileOutputStream(file2);

        if (inputStream.available() > 0) {
            //читаем весь файл одним куском
            byte[] buffer = new byte[inputStream.available()];
            int count = inputStream.read(buffer);
            //переворачиваем массив
            byte[] buffer2 = new byte[buffer.length];
            for (int i = 0; i < buffer.length; i++) {
                buffer2[buffer.length - i - 1] = buffer[i];
            }
            outputStream.write(buffer2, 0, count);
        }

        inputStream.close();
        outputStream.close();

    }
}
