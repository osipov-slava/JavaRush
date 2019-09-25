package com.javarush.task.task20.task2009;

import java.io.*;

/*
Как сериализовать static?
*/
public class Solution {
    public static class ClassWithStatic implements Serializable{
        public static String staticString = "This is a static test string";
        public int i;
        public int j;
    }

    public static void main(String[] args) throws Exception{
        FileOutputStream fileOutput = new FileOutputStream("1.txt");
        ObjectOutputStream outputStream = new ObjectOutputStream(fileOutput);

        ClassWithStatic cws = new ClassWithStatic();
        outputStream.writeObject(cws);
        fileOutput.close();
        outputStream.close();

        FileInputStream fiStream = new FileInputStream("1.txt");
        ObjectInputStream objectStream = new ObjectInputStream(fiStream);
        Object object = objectStream.readObject();
        fiStream.close();
        objectStream.close();

        ClassWithStatic cws1 = (ClassWithStatic)object;
        System.out.println(ClassWithStatic.staticString);



    }
}
