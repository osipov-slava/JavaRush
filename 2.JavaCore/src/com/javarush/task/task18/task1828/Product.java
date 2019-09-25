package com.javarush.task.task18.task1828;

import java.util.ArrayList;

public class Product {

    public static ArrayList<Product> products = new ArrayList<>();

    static int idMax = 0;

    String fullString;
    String idStr;
    String productName;
    String priceStr;
    String quantityStr;
    Integer id;
    double price;
    int quantity;

    Product(String str){
        fullString = str;
        idStr = fullString.substring(0,8);
        productName = fullString.substring(8,38);
        priceStr = fullString.substring(38,46);
        quantityStr = fullString.substring(46,50);
        id = Integer.parseInt(idStr.replace(" ",""));
        price = Double.parseDouble(priceStr.replace(" ","").replace(",", "."));
        quantity = Integer.parseInt(quantityStr.replace(" ",""));
        if (id > idMax) idMax = id;
    }

    Product(String productName, double price, int quantity ){
        id = ++idMax;
        idStr = String.format("%-8d", id);
        this.productName = String.format("%-30s",productName);
        this.price = price;
        this.quantity = quantity;
        priceStr = String.format("%-8.2f",price);
        quantityStr = String.format("%-4d",quantity);
        fullString = this.idStr + this.productName + this.priceStr + this.quantityStr;
    }

    public void update (String productName, double price, int quantity){
        this.productName = String.format("%-30s",productName);
        this.price = price;
        this.quantity = quantity;
        priceStr = String.format("%-8.2f",price);
        quantityStr = String.format("%-4d",quantity);
        fullString = this.idStr + this.productName + this.priceStr + this.quantityStr;
    }
}
