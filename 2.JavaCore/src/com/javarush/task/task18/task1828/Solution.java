package com.javarush.task.task18.task1828;

/* 
Прайсы 2
*/

import java.io.*;
import java.util.Iterator;

public class Solution {
    public static void main(String[] args) throws IOException{

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String file = reader.readLine();

        if (args.length == 0) return;
        if (args[0].equals("-c")) createProduct (args, file);
        if (args[0].equals("-u")) updateProduct (args, file);
        if (args[0].equals("-d")) deleteProduct (args[1], file);

    }

    static void readProductsFromFile(String file) throws IOException{
        //читаем текущие данные
        BufferedReader readerFile = new BufferedReader(new InputStreamReader(new FileInputStream(file)));
        String strLine;
        while ((strLine = readerFile.readLine()) != null){
            Product.products.add(new Product(strLine));
        }
        readerFile.close();
    }

    static void writeProductsToFile(String file) throws IOException {
        BufferedWriter writerFile = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(file)));
        for (Product pr:Product.products) {
            writerFile.write(pr.fullString);
            writerFile.newLine();
        }
        writerFile.close();
    }

    static void updateProduct (String[] args, String file) throws IOException{
        readProductsFromFile(file);
        //используем итератор, для поиска? можно найти быстрее?
        for (Iterator<Product> it = Product.products.iterator(); it.hasNext(); ) {
            Product element = it.next();
            if (element.id == Integer.parseInt(args[1]) ) {
                element.update((args[2]), Double.parseDouble(args[3]), Integer.parseInt(args[4]));
            }
        }
        writeProductsToFile(file);
    }

    static void deleteProduct (String idStr, String file) throws IOException{
        readProductsFromFile(file);
        //используем итератор, чтобы удалять во время цикла
        for (Iterator<Product> it = Product.products.iterator(); it.hasNext();) {
            Product element = it.next();
            if (element.id == Integer.parseInt(idStr) ) {
                it.remove();
            }
        }
        writeProductsToFile(file);
    }

    static void createProduct (String[] args, String file) throws IOException {
        readProductsFromFile(file);
        //добавляем новый объект в список
        Product.products.add(new Product((args[1]), Double.parseDouble(args[2]), Integer.parseInt(args[3])));
        //выгружаем в файл
        writeProductsToFile(file);
    }
}
