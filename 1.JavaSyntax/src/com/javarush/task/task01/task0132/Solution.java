package com.javarush.task.task01.task0132;

/* 
Сумма цифр трехзначного числа
*/

public class Solution {
    public static void main(String[] args) {
        System.out.println(sumDigitsInNumber(546));
    }

    public static int sumDigitsInNumber(int number) {
        int a,s1,s2,s3;
        s1=number/100;
        s2=(number-s1*100)/10;
        s3=(number % 10);
        return (s1+s2+s3);//напишите тут ваш код
    }
}