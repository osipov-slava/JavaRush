package com.javarush.task.task18.task1825;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/* 
Собираем файл
*/

public class Solution {
    public static void main(String[] args) throws IOException{
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        Comparator<String> comparator = new Comparator<String>(){
            @Override
            public int compare(String o1, String o2) {
                String str1 = o1.substring(o1.indexOf(".part")+5);
                String str2 = o2.substring(o2.indexOf(".part")+5);
                Integer id1 = Integer.parseInt(str1);
                Integer id2 = Integer.parseInt(str2);
                return id1.compareTo(id2);
            }

        };

        SortedSet<String> files = new TreeSet<String>(comparator);
        do {
            String file = reader.readLine();
            if (file.equals("end")) break;
            files.add(file);
        } while (true);


        String fileOut = files.last().substring(0,files.last().indexOf(".part"));
        FileOutputStream outputStream = new FileOutputStream(fileOut);

        for (String fileIn: files) {
            FileInputStream inputStream = new FileInputStream(fileIn);
            if (inputStream.available() > 0) {
                byte[] buffer = new byte[inputStream.available()];
                int count = inputStream.read(buffer);
                outputStream.write(buffer, 0, count);
                outputStream.flush();
            }
            inputStream.close();
        }

        outputStream.close();

    }
}
