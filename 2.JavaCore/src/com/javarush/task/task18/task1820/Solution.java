package com.javarush.task.task18.task1820;

/* 
Округление чисел
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException{
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String file1 = reader.readLine();
        String file2 = reader.readLine();
        reader.close();

        FileInputStream inputStream = new FileInputStream(file1);
        InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
        BufferedReader readerFile = new BufferedReader(inputStreamReader);
        FileOutputStream outputStream = new FileOutputStream(file2);

        String strLine;
        if ((strLine = readerFile.readLine()) == null) throw new IOException();
        String[] strings = strLine.split(" ");
        float[] floats = new float[strings.length];
        for (int i = 0; i < strings.length; i++) {
            floats[i] = Float.parseFloat(strings[i]);
        }

        int[] ints = roundFloat (floats);
        strLine = "";
        for (int i = 0; i < ints.length; i++) {
            strLine = strLine + ints[i] + " ";
        }

        byte[] buffer = strLine.getBytes();
        outputStream.write(buffer, 0, strLine.length());

        readerFile.close();
        outputStream.close();
    }

    public static int[] roundFloat (float[] floats){
        int[] ints = new int[floats.length];
        for (int i = 0; i < floats.length; i++) {
            ints[i] = Math.round(floats[i]);
        }

        return ints;
    }
}
