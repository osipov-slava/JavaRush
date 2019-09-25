package com.javarush.task.task22.task2212;

/* 
Проверка номера телефона
*/
public class Solution {
    public static boolean checkTelNumber(String telNumber) {
        if (telNumber==null) return false;
        if (telNumber=="") return false;
        if (telNumber.matches("\\w")) return false;
        if (telNumber.matches("-{2,}")) return false;
        if (telNumber.matches("(.*-.*){3,}")) return false;
        if (telNumber.matches(".*-.*[(]")) return false;
        if (telNumber.matches(".*\\(.*")) if (!telNumber.matches(".*\\(\\d{3}\\).*")) return false;
        if (telNumber.matches(".*\\D")) return false;
        return telNumber.matches("^\\+([(]?\\d[-()]?){12}") | telNumber.matches("^([(]?\\d[-()]?){10}");
    }

    public static void main(String[] args) {
        System.out.println("+380501234567 " + checkTelNumber("+380501234567"));
        System.out.println("+38(050)1234567 " + checkTelNumber("+38(050)1234567"));
        System.out.println("+38050123-45-67 " + checkTelNumber("+38050123-45-67"));
        System.out.println("050123-4567 " + checkTelNumber("050123-4567"));
        System.out.println("+38)050(1234567 " + checkTelNumber("+38)050(1234567"));
        System.out.println("+38(050)1-23-45-6-7 " + checkTelNumber("+38(050)1-23-45-6-7"));
        System.out.println("050ххх4567 " + checkTelNumber("050ххх4567"));
        System.out.println("050123456 " + checkTelNumber("050123456"));
        System.out.println("(0)50123456 " + checkTelNumber("(0)50123456"));
        System.out.println("+38050123-45--67 " + checkTelNumber("+38050123-45--67"));
    }
}
