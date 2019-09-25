package com.javarush.task.task18.task1826;

/* 
Шифровка
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        encoder(args[0],args[1],args[2]);
    }

    public static void encoder (String work, String fileIn, String fileOut) throws IOException{
        if (work.equals("-e") || work.equals("-d")) {
            FileInputStream inputStream = new FileInputStream(fileIn);
            FileOutputStream outputStream = new FileOutputStream(fileOut);

            while (inputStream.available() > 0) {
                int data = inputStream.read(); //читаем один байт из потока для чтения
                outputStream.write(~data); //записываем прочитанный байт в другой поток.
            }

            inputStream.close();
            outputStream.close();
        }
    }
}