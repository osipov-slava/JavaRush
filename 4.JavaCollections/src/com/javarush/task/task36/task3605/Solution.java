package com.javarush.task.task36.task3605;

import java.io.*;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Iterator;
import java.util.TreeSet;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* 
Использование TreeSet
*/
public class Solution {
    public static void main(String[] args) throws IOException {
        Path file1 = Paths.get(args[0]);
        FileInputStream inputStream = new FileInputStream(file1.toString());
        String string = "";
        if (inputStream.available() > 0) {
            //читаем весь файл одним куском
            byte[] buffer = new byte[inputStream.available()];
            inputStream.read(buffer);
            string = new String(buffer);
        }
        string = string.toLowerCase();
        byte[] array = string.getBytes();
        TreeSet<Byte> treeSet = new TreeSet<>();
        for (Byte b : array) {
            if (b >= 'a' && b <= 'z') treeSet.add(b);
        }

        Iterator<Byte> iterator = treeSet.iterator();
        for (int i = 0; i < treeSet.size(); i++) {
            if (i == 5) break;
            char ch = (char) (byte) iterator.next();
            System.out.print(ch);
        }
    }
}
