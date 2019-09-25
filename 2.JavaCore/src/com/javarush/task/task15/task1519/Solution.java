package com.javarush.task.task15.task1519;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

/* 
Разные методы для разных типов
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        do {

            String str = reader.readLine();
            if ("exit".equals(str)) break;

            try {
                int i = Integer.parseInt(str);
                if (i>0 && i<128) {
                    print ((short) i);
                    continue;
                }
                else {
                    print(i);
                    continue;
                }
            }
            catch (NumberFormatException e) {

            }

            try {
                double d = Double.parseDouble(str);
                print (d);
                continue;

            }
            catch (NumberFormatException e) {

            }

            print(str);


        } while (true);

        reader.close();
    }

    public static void print(Double value) {
        System.out.println("Это тип Double, значение " + value);
    }

    public static void print(String value) {
        System.out.println("Это тип String, значение " + value);
    }

    public static void print(short value) {
        System.out.println("Это тип short, значение " + value);
    }

    public static void print(Integer value) {
        System.out.println("Это тип Integer, значение " + value);
    }
}
