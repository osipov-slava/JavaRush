package com.javarush.task.task07.task0708;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/* 
Самая длинная строка
*/

public class Solution {
    private static ArrayList<String> strings= new ArrayList<String>();

    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        //ArrayList<String> strings = new ArrayList<String>();

        for (int i=0;i<5;i++)
            strings.add(reader.readLine());//внести строки с клавиатуры

        //найти максимальную длину строки
        String strMax=strings.get(0);
        int lenMax = strMax.length();

        for (int i=0;i<5;i++){
            String strNew=strings.get(i);
            int lenNew = strNew.length();
            if (lenMax<lenNew) lenMax=lenNew;
        }

        for (int i=0;i<5;i++){
            String strNew=strings.get(i);
            int lenNew = strNew.length();
            if (lenMax==lenNew) System.out.println(strings.get(i));;
        }
    }
}
