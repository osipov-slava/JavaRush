package com.javarush.task.task04.task0433;


/* 
Гадание на долларовый счет
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws Exception {
        //напишите тут ваш код
        int i=0,j=0;
        while (i<10){
            while (j<10) {
                System.out.print("S");
                j++;
            }
            j=0;
            System.out.println("");
            i++;
        }
    }
}
