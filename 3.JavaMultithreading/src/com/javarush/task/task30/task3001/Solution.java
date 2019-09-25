package com.javarush.task.task30.task3001;

import java.math.BigInteger;
import java.util.regex.Pattern;

import static com.javarush.task.task30.task3001.NumberSystemType._16;

/*
Конвертер систем счислений
*/
public class Solution {
    public static void main(String[] args) {
        Number number1 = new Number(NumberSystemType._8, "543");
        Number result1 = convertNumberToOtherNumberSystem(number1, NumberSystemType._8);
        System.out.println(result1);    //expected 110

        Number number = new Number(NumberSystemType._10, "6");
        Number result = convertNumberToOtherNumberSystem(number, NumberSystemType._2);
        System.out.println(result);    //expected 110

        number = new Number(_16, "6df");
        result = convertNumberToOtherNumberSystem(number, NumberSystemType._8);
        System.out.println(result);    //expected 3337

        number = new Number(_16, "abcdefabcdef");
        result = convertNumberToOtherNumberSystem(number, _16);
        System.out.println(result);    //expected abcdefabcdef
    }

    public static Number convertNumberToOtherNumberSystem(Number number, NumberSystem expectedNumberSystem) {
        BigInteger base10 = new BigInteger(number.getDigit(), number.getNumberSystem().getNumberSystemIntValue());
        String result = base10.toString(expectedNumberSystem.getNumberSystemIntValue());
        Number res = new Number(expectedNumberSystem, result);
//        //валидация данных по возможным символам
//        String setSymbol = getSetSymbol(number.getNumberSystem());
//        //проверяем на regex типа "[0123456789abcdef]+"
//        if (!Pattern.matches("[" + setSymbol + "]+", number.getDigit())) throw new NumberFormatException();
//
//        //преобразовать в int универсально
//        String[] arrInDigit = number.getDigit().split("");
//        long digitBase10 = 0;
//        int base = setSymbol.length(); // основание, для двоичной системы 2, для шестнадцатиричной 16
//
//        for (int i = 0; i < arrInDigit.length; i++) {
//            String d = arrInDigit[arrInDigit.length - i - 1]; // символ в переданной строке с конца
//            int digit = setSymbol.indexOf(d); //Перевод символа в число, для 'c' = 13
//
//            digitBase10 += digit * Math.pow(base, i); // разряд * разрядность в степени i
//        }
//
//        //универсальная функция по переводу из int в новую систему
//        //получаем набор символов для новой системы счисления
//        StringBuilder sb = new StringBuilder();
//        setSymbol = getSetSymbol(expectedNumberSystem);
//        base = setSymbol.length(); // основание, для двоичной системы 2, для шестнадцатиричной 16
//
////        — Тут все тоже очень похоже. Давай попробуем перевести число 35510 обратно в восьмеричный формат.
////
////        Сначала мы разделим его на 64 (82), получим 5 целых и 35 в остатке. Значит первая цифра
////        нашего числа – 5. Затем разделим остаток на 8(81), получим 4 и 3 в остатке. Так и получится число 5438.
//        int countDigits = getCountsOfDigits(digitBase10); //количество разрядов в 10 ричной числе
//        for (int i = 0; i < countDigits; i++) {
//            long a = digitBase10 / ( int) Math.pow(base, countDigits - i - 1);
//            sb.append(String.valueOf(a));
//            digitBase10 -= a * Math.pow(base, countDigits - i - 1);
//        }
//
//        Number newNumber = new Number(expectedNumberSystem, sb.toString());
//
//        return newNumber;
//    }
//
//    public static String getSetSymbol(NumberSystem type) {
//        switch (type.getNumberSystemIntValue()) {
//            case 2:
//                return "01";
//            case 3:
//                return "012";
//            case 4:
//                return "0123";
//            case 5:
//                return "01234";
//            case 6:
//                return "012345";
//            case 7:
//                return "0123456";
//            case 8:
//                return "01234567";
//            case 9:
//                return "012345678";
//            case 10:
//                return "0123456789";
//            case 12:
//                return "[0123456789ab]";
//            case 16:
//                return "[0123456789abcdef]";
//        }
//        return "";
//    }
//
//    public static int getCountsOfDigits(long number) {
//        int count = (number == 0) ? 1 : 0;
//        while (number != 0) {
//            count++;
//            number /= 10;
//        }
        return res;
    }
}
