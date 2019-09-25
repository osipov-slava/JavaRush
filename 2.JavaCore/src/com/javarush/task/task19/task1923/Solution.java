package com.javarush.task.task19.task1923;

/* 
Слова с цифрами
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException{
        BufferedReader readerFile = new BufferedReader(new FileReader(args[0]));
        BufferedWriter writerFile = new BufferedWriter(new FileWriter(args[1]));
        while (readerFile.ready()) {
            String str = readerFile.readLine();
            String [] strings = str.split("\\s");
            for (int i = 0; i < strings.length; i++) {
                if (strings[i].matches("\\S*\\d+\\S*")) writerFile.write(strings[i] + " ");
            }
        }
        readerFile.close();
        writerFile.close();
    }
}
