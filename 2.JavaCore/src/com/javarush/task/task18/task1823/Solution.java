package com.javarush.task.task18.task1823;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

/* 
Нити и байты
*/

public class Solution {
    public static Map<String, Integer> resultMap = new HashMap<String, Integer>();

    public static void main(String[] args) throws IOException{
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String file;
        do{
            file = reader.readLine();
            if (file.equals("exit")) break;
            ReadThread readThread = new ReadThread(file);
            readThread.start();
        } while (true);
        reader.close();
/*
        for (Map.Entry<String,Integer> pair: resultMap.entrySet()) {
            System.out.println(pair.getKey() + " " + pair.getValue());
        }*/
    }

    public static class ReadThread extends Thread {
        private String file = "";
        public ReadThread(String fileName) {
            file = fileName;

        }

        public void run() {
            try {
                FileInputStream inputStream = new FileInputStream(file);
                int[] ch = new int[255];
                int max = 0;
                int maxSymbol = 0;
                while (inputStream.available() > 0) {
                    int symbol = inputStream.read();
                    ch[symbol]++;
                    if (ch[symbol]> max) {
                        max = ch[symbol];
                        maxSymbol = symbol;
                    }
                }
                inputStream.close();
                resultMap.put(file, maxSymbol);
            } catch (IOException e) {
                System.out.println("Ошибка чтения файла");
                e.printStackTrace();
            }
        }

        // implement file reading here - реализуйте чтение из файла тут
    }
}
