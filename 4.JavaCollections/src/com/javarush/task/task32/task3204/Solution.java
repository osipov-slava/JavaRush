package com.javarush.task.task32.task3204;

import java.io.ByteArrayOutputStream;

/* 
Генератор паролей
*/
public class Solution {
    public static void main(String[] args) {
        ByteArrayOutputStream password = getPassword();
        System.out.println(password.toString());
    }

    public static ByteArrayOutputStream getPassword() {
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        int number = (int) (Math.random() * 26) + 65;
        baos.write(number);
        number = (int) (Math.random() * 26) + 97;
        baos.write(number);
        number = (int) (Math.random() * 10) + 48;
        baos.write(number);
        for (int i = 0; i < 5; i++) {
            number = (int) (Math.random() * (26 + 26 + 10));
            if (number < 26) number += 65;
            else if (number < 52) number += -26 + 97;
            else number += -26 - 26 + 48;
            baos.write(number);
        }
        return baos;
    }
}