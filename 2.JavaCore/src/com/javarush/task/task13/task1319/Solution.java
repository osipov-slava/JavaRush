package com.javarush.task.task13.task1319;

import java.io.*;

/* 
Писатель в файл с консоли
*/

public class Solution {
    public static void main(String[] args) throws IOException{
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String fileName = reader.readLine();

        try {
            BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(fileName));
            String string;

            do
            {
                string = reader.readLine();
                char [] ch = string.toCharArray();
                for (int i=0; i<ch.length;i++)
                    bufferedWriter.write(ch[i]);
                bufferedWriter.append("\n");
            } while (!string.equals("exit"));
            bufferedWriter.flush();
            bufferedWriter.close(); //закрываем потоки

        }
        catch (FileNotFoundException e){
            System.out.println("file not found!");
        }
        reader.close();

    }
}
