package com.javarush.task.task18.task1824;

/* 
Файлы и исключения
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String file = "";
        FileInputStream inputStream = null;
        try {
            do{
                file = reader.readLine();
                inputStream = new FileInputStream(file);
                inputStream.close();

            } while (true);
        } catch (FileNotFoundException e) {
            System.out.println(file);
            //inputStream.close();
            return;
        } catch (IOException e){
            return;
        }
    }
}
