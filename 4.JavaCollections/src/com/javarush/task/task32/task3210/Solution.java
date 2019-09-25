package com.javarush.task.task32.task3210;

import java.io.IOException;
import java.io.RandomAccessFile;

/* 
Используем RandomAccessFile
*/

public class Solution {
    public static void main(String... args) throws IOException{
        RandomAccessFile raf = new RandomAccessFile(args[0], "rw");
        int number = Integer.parseInt(args[1]);
        int length = args[2].getBytes().length;
        //считываем строку из файла
        raf.seek(number);
        byte[] b = new byte[length];
        raf.read(b, 0, length);
        String textFromFile = new String(b);

        raf.seek(raf.length());
        if (textFromFile.equals(args[2])) raf.write("true".getBytes());
        else raf.write("false".getBytes());

        raf.close();
    }
}
