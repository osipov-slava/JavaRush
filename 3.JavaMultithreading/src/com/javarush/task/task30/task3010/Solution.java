package com.javarush.task.task30.task3010;

/* 
Минимальное допустимое основание системы счисления
*/

import java.math.BigInteger;

public class Solution {
    public static void main(String[] args) {
        boolean flag = false;
        for (int i = 36; i >= 2; i--) {
            BigInteger bi = null;
            try {
                bi = new BigInteger(args[0],i);
                flag = true;
            } catch (Exception e) {
                if (bi == null && !flag) System.out.println("incorrect");
                else System.out.println(i+1);
                return;
            }
        }
        System.out.println(2);
        //напишите тут ваш код
    }
}