package com.javarush.task.task18.task1827;

/* 
Прайсы
*/

import java.io.*;
import java.util.*;

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String file = reader.readLine();

        if (args.length == 0) return;
        if (args[0].equals("-c")) createProduct (args, file);
    }

    static void createProduct (String[] args, String file) throws IOException{
        //Сортированный список объектов Product
        Comparator<Product> comparator = new Comparator<Product>(){
            @Override
            public int compare(Product p1, Product p2) {
                return p1.id.compareTo(p2.id);
            }
        };
        SortedSet<Product> products = new TreeSet<Product>(comparator);

        //читаем текущие данные
        BufferedReader readerFile = new BufferedReader(new InputStreamReader(new FileInputStream(file)));
        String strLine;
        while ((strLine = readerFile.readLine()) != null){
            products.add(new Product(strLine));
        }
        readerFile.close();
        //добавляем новый объект в список
        products.add(new Product((args[1]), Double.parseDouble(args[2]), Integer.parseInt(args[3])));
        //выгружаем в файл
        BufferedWriter writerFile = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(file)));
        for (Product pr:products) {
            writerFile.write(pr.fullString);
            writerFile.newLine();
        }
        writerFile.close();
    }
}
