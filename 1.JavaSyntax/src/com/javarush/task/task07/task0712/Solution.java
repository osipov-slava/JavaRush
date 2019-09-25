package com.javarush.task.task07.task0712;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

/* 
Самые-самые
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        ArrayList<String> strings= new ArrayList<String>();
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        for (int i=0;i<10;i++)
            strings.add(reader.readLine());//внести строки с клавиатуры

        //найти минимальную и максимальную длину строки
        String strMin=strings.get(0);
        int lenMin = strMin.length();
        String strMax=strings.get(0);
        int lenMax = strMax.length();

        for (int i=0;i<10;i++){
            String strNew=strings.get(i);
            int lenNew = strNew.length();
            if (lenMin>lenNew) lenMin=lenNew;
            if (lenMax<lenNew) lenMax=lenNew;
        }

        //определение первого минимального и первого максимального значения
        boolean firstMinString=false;
        for (int i=0;i<strings.size();i++){
            String strNew=strings.get(i);
            int lenNew = strNew.length();
            if (lenMin==lenNew){
                firstMinString=true;
                System.out.println(strings.get(i));
                break;
            }
            if (lenMax==lenNew) {
                System.out.println(strings.get(i));
                break;
            }
        }

    }
}
