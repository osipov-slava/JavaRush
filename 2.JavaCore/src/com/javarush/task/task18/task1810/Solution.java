package com.javarush.task.task18.task1810;

/* 
DownloadException
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws DownloadException, IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        do {

            String file1 = reader.readLine();


            FileInputStream inputStream = new FileInputStream(file1);
            if (inputStream.available() < 1000) {
                inputStream.close();
                reader.close();
                throw new DownloadException();
            }
            else inputStream.close();
            System.out.println(1);
        } while (true);

    }

    public static class DownloadException extends Exception {

    }
}
