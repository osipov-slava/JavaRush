package com.javarush.task.task13.task1318;

import java.io.*;
import java.util.Scanner;

/* 
Чтение файла
*/

public class Solution {
    public static void main(String[] args) throws IOException{
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String fileName = reader.readLine();

        try {
            InputStream inStream = new FileInputStream(fileName);

            while (inStream.available() > 0)
            {
                int data = inStream.read(); //читаем один байт из потока для чтения
                System.out.print((char)data); //записываем прочитанный байт в другой поток.
            }

            inStream.close(); //закрываем потоки

        }
        catch (FileNotFoundException e){
            System.out.println("file not found!");
        }
        reader.close();
        //OutputStream outStream = new FileOutputStream("c:/result.txt");



    }
}