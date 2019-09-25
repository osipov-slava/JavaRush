package com.javarush.task.task10.task1012;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

/* 
Количество букв
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        // алфавит
        String abc = "абвгдеёжзийклмнопрстуфхцчшщъыьэюя";
        char[] abcArray = abc.toCharArray();
        int[] sumChar= new int[33];

        ArrayList<Character> alphabet = new ArrayList<Character>();
        for (int i = 0; i < abcArray.length; i++) {
            alphabet.add(abcArray[i]);
        }

        // ввод строк
        ArrayList<String> list = new ArrayList<String>();
        for (int i = 0; i < 10; i++) {
            String s = reader.readLine();
            list.add(s.toLowerCase());
        }
        for (int i = 0; i<list.size(); i++) {
            char[] str = list.get(i).toCharArray();
            for (int j = 0; j < str.length; j++){
                for (int k = 0; k<abcArray.length;k++){
                    if (str[j]==abcArray[k]){
                            sumChar[k]++;
                    }
                }

            }


        }
        for (int i=0; i<sumChar.length; i++)
            System.out.println(abcArray[i]+" "+sumChar[i]);



    }

}
