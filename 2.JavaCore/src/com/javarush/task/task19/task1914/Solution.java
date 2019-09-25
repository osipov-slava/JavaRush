package com.javarush.task.task19.task1914;

/* 
Решаем пример
*/

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public class Solution {
    public static TestString testString = new TestString();

    public static void main(String[] args) {
        PrintStream consoleStream = System.out;
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        PrintStream stream = new PrintStream(outputStream);
        System.setOut(stream);

        //Вызываем функцию, которая ничего не знает о наших манипуляциях
        testString.printSomething();

        //Преобразовываем записанные в наш ByteArray данные в строку
        String result = outputStream.toString();

        String[] math = result.split(" ");
        switch (math[1]) {
            case "+" : {result = result +
                        (Integer.parseInt(math[0]) + Integer.parseInt(math[2]));
                        break;}
            case "-" : {result = result +
                        (Integer.parseInt(math[0]) - Integer.parseInt(math[2]));
                        break;}
            case "*" : {result = result.substring(0,result.length()-2) +
                        (Integer.parseInt(math[0]) * Integer.parseInt(math[2]));
                        break;}
        }
        //Возвращаем все как было
        System.setOut(consoleStream);
        System.out.println(result);
    }

    public static class TestString {
        public void printSomething() {
            System.out.println("3 + 6 = ");
        }
    }
}

