package com.javarush.task.task18.task1818;

/* 
Два в одном
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException{
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String file1 = reader.readLine();
        String file2 = reader.readLine();
        String file3 = reader.readLine();
        reader.close();

        FileOutputStream outputStream = new FileOutputStream(file1);
        FileInputStream inputStream1 = new FileInputStream(file2);
        FileInputStream inputStream2 = new FileInputStream(file3);


        if (inputStream1.available() > 0) {
            //читаем весь файл одним куском
            byte[] buffer = new byte[inputStream1.available()];
            int count = inputStream1.read(buffer);
            outputStream.write(buffer, 0, count);
            outputStream.flush();
        }
        if (inputStream2.available() > 0) {
            byte[] buffer = new byte[inputStream2.available()];
            int count = inputStream2.read(buffer);
            outputStream.write(buffer, 0, count);
        }

        inputStream1.close();
        inputStream2.close();
        outputStream.close();

    }
}
