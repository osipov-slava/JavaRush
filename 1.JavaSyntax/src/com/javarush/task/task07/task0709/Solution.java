package com.javarush.task.task07.task0709;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

/* 
Выражаемся покороче
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        ArrayList<String> strings= new ArrayList<String>();
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        for (int i=0;i<5;i++)
            strings.add(reader.readLine());//внести строки с клавиатуры

        //найти минимальную длину строки
        String strMin=strings.get(0);
        int lenMin = strMin.length();

        for (int i=0;i<5;i++){
            String strNew=strings.get(i);
            int lenNew = strNew.length();
            if (lenMin>lenNew) lenMin=lenNew;
        }

        for (int i=0;i<5;i++){
            String strNew=strings.get(i);
            int lenNew = strNew.length();
            if (lenMin==lenNew) System.out.println(strings.get(i));
        }
    }
}
