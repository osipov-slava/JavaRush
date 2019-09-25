package com.javarush.task.task19.task1925;

/* 
Длинные слова
*/

import java.io.*;
import java.util.ArrayList;

public class Solution {
    public static void main(String[] args) throws IOException{
        BufferedReader readerFile = new BufferedReader(new FileReader(args[0]));
        BufferedWriter writerFile = new BufferedWriter(new FileWriter(args[1]));

        ArrayList<String[]> arrStrings = new ArrayList<>();
        while (readerFile.ready()){
            arrStrings.add(readerFile.readLine().split(" "));
        }

        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < arrStrings.size(); i++) {
            for (int j = 0; j < arrStrings.get(i).length; j++) {
                if (arrStrings.get(i)[j].length() > 6) {
                    stringBuilder.append(arrStrings.get(i)[j] + ",");
                }
            }
        }

        writerFile.write(stringBuilder.substring(0,stringBuilder.length()-1));

        readerFile.close();
        writerFile.close();
    }

}

