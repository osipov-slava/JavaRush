package com.javarush.task.task22.task2209;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
Составить цепочку слов
*/
public class Solution {
    public static void main(String[] args) throws IOException{
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String file = reader.readLine();
        reader.close();

        BufferedReader readerFile = new BufferedReader(new InputStreamReader(new FileInputStream(file)));
        StringBuilder fileData = new StringBuilder();
        fileData.append(readerFile.readLine());
        readerFile.close();

        String[] stringsAll = fileData.toString().trim().split(" ");

        List<String> array = new ArrayList<>();
        for (int i = 0; i < stringsAll.length ; i++) {
            if (!stringsAll[i].equals("")) array.add(stringsAll[i]);
        }

        String[] strings = new String[array.size()];
        array.toArray(strings);

        StringBuilder result = getLine(strings);
        System.out.println(result.toString());
    }

    public static StringBuilder getLine(String... words) {
        //Киев Нью-Йорк Амстердам Вена Мельбурн Алмаата Москва Питер Вашингтон Гамбург Венеция Ростов-на-Дону    Киров Киров Варшава Артек Уссурийск колобок
        StringBuilder sb = new StringBuilder();
        if (words.length == 0) return sb.append("");

        String[] wordsCopy = words.clone();

        Graf graf = new Graf(wordsCopy);
        graf.findBestChain();

        for (Integer i : graf.bestChain) {
            sb.append(words[i]);
            sb.append(" ");
        }
        sb.delete(sb.length() - 1, sb.length());
        return sb;
    }
}
