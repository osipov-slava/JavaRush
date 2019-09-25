package com.javarush.task.task32.task3210;

import java.io.*;

public class test {
    public static void main(String[] args) throws IOException {
        String test = "Slava\n 42\n";
        Reader reader = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(reader);
        String name = br.readLine();
        //здесь может быть много кода
        String age = br.readLine();
        //здесь может быть много кода
        System.out.println("Name - " + name + "\tAge - " + age);

    }
}
