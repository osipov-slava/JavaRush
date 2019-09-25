package com.javarush.task.task03.task0303;

/* 
Обмен валют
*/

public class Solution {
    public static void main(String[] args) {
        System.out.println(convertEurToUsd(10,55.2));
        System.out.println(convertEurToUsd(50,75.2));//напишите тут ваш код
    }

    public static double convertEurToUsd(int eur, double course) {
        double usd = eur * course;
        return (usd);//напишите тут ваш код
    }
}
