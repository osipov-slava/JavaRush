package com.javarush.task.task13.task1326;

/* 
Сортировка четных чисел из файла
*/

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;

public class Solution {
    public static void main(String[] args) throws IOException{
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader fileReader = new BufferedReader(new InputStreamReader(new FileInputStream(reader.readLine())));

        ArrayList<Integer> list = new ArrayList<Integer>();

        try {


            while (fileReader.ready())
            {
                list.add(Integer.parseInt(fileReader.readLine()));

            }

            fileReader.close(); //закрываем потоки

        }
        catch (FileNotFoundException e){
            System.out.println("file not found!");
        }

        reader.close();

        ArrayList<Integer> even  = new ArrayList<>();

        for (Integer a : list)
            if (a%2==0) even.add(a);

        Collections.sort(even);

        for (Integer a : even)
            System.out.println(a);

    }
}
