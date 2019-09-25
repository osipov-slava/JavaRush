package com.javarush.task.task07.task0718;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

/* 
Проверка на упорядоченность
*/
public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        ArrayList<String> strings= new ArrayList<String>();

        for (int i=0;i<10;i++) strings.add(reader.readLine());

        int lengthStr=0, firstElement=0;
        boolean good=true;

        for (int i=0; i<strings.size(); i++ ){
            String str = strings.get(i);
            firstElement=i;
            if (lengthStr>=str.length()) {
                good=false;
                break;
            }
            lengthStr=str.length();

        }

        if (!good) System.out.println(firstElement);
    }
}

