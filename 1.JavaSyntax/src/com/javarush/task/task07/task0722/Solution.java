package com.javarush.task.task07.task0722;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

/* 
Это конец
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        ArrayList<String> strings = new ArrayList<String>();
        for (int i = 0; true; i++) {
            String str = reader.readLine();
            if (str.equals("end")) break;
            strings.add(str);
        }

        for (String x: strings)
            System.out.println(x);

        //напишите тут ваш код
    }
}