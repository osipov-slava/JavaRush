package com.javarush.task.task18.task1819;

/* 
Объединение файлов
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException{
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String file1 = reader.readLine();
        String file2 = reader.readLine();
        reader.close();


        FileInputStream inputStream = new FileInputStream(file1);
        byte[] buffer1 = null;
        int count1 = 0;
        if (inputStream.available() > 0) {
            buffer1 = new byte[inputStream.available()];
             count1 = inputStream.read(buffer1);
        }
        inputStream.close();

        inputStream = new FileInputStream(file2);
        FileOutputStream outputStream = new FileOutputStream(file1);
        if (inputStream.available() > 0) {
            byte[] buffer2 = new byte[inputStream.available()];
            int count2 = inputStream.read(buffer2);
            outputStream.write(buffer2, 0, count2);
            outputStream.write(buffer1, 0, count1);
        }

        inputStream.close();
        outputStream.close();
    }
}
