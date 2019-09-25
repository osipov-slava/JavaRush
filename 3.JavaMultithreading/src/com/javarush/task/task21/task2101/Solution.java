package com.javarush.task.task21.task2101;

import java.lang.reflect.Array;

/*
Определяем адрес сети
*/
public class Solution {
    public static void main(String[] args) {
        byte[] ip = new byte[]{(byte) 192, (byte) 168, 1, 2};
        byte[] mask = new byte[]{(byte) 255, (byte) 255, (byte) 254, 0};
        byte[] netAddress = getNetAddress(ip, mask);
        print(ip);          //11000000 10101000 00000001 00000010
        print(mask);        //11111111 11111111 11111110 00000000
        print(netAddress);  //11000000 10101000 00000000 00000000
    }

    public static byte[] getNetAddress(byte[] ip, byte[] mask) {
        byte[] res = new byte[4];
        for (int i = 0; i < 4; i++) {
            res[i] = (byte) (ip[i] & mask[i]);
        }
        return res;
    }

    public static void print(byte[] bytes) {
        char[][] chars = new char [4][8];

        for (int i = 0; i < 4; i++) {
            int a = bytes[i]; //для удобства чтения
            for (int j = 0; j < 8; j++) {
                a = a & 255;
                if (a % 2 == 1) chars[i][7-j] = '1';
                else chars[i][7-j] = '0';
                a = a>>>1;
            }
        }

        System.out.println(String.valueOf(chars[0]) + " " +
                String.valueOf(chars[1]) + " " +
                String.valueOf(chars[2]) + " " +
                String.valueOf(chars[3]));

    }
}
