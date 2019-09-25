package com.javarush.task.task34.task3404;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.util.Stack;

/*
Рекурсия для мат. выражения
*/
public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
//        solution.recurse("sin(2*(-5+1.5*4)+28)", 0); //expected output 0.5 6
//        solution.recurse("tan(45)", 0);  System.out.println("1 1 - expected output");
//        solution.recurse("tan(-45)", 0);  System.out.println("-1 2 - expected output");
        solution.recurse("0.305", 0);  System.out.println("0.3 0 - expected output");
        solution.recurse("0.3051" , 0);  System.out.println("0.31 - expected output");
        solution.recurse("(0.3051)", 0);  System.out.println("0.31 - expected output");
        solution.recurse("1+(1+(1+1)*(1+1))*(1+1)+1", 0);  System.out.println("12 8 - expected output");
//        solution.recurse("tan(44+sin(89-cos(180)^2))", 0);  System.out.println("1 6 - expected output");
//        solution.recurse("-2+(-2+(-2)-2*(2+2))", 0);  System.out.println("-14 8 - expected output");
//        solution.recurse("sin(80+(2+(1+1))*(1+1)+2)", 0);  System.out.println("1 7 - expected output");
//        solution.recurse("1+4/2/2+2^2+2*2-2^(2-1+1)", 0);  System.out.println("6 11 - expected output");
//        solution.recurse("10-2^(2-1+1)", 0);  System.out.println("6 4 - expected output");
//        solution.recurse("2^10+2^(5+5)", 0);  System.out.println("2048 4 - expected output");
//        solution.recurse("1.01+(2.02-1+1/0.5*1.02)/0.1+0.25+41.1", 0);  System.out.println("72.96 8 - expected output");
//        solution.recurse("0.000025+0.000012", 0);  System.out.println("0 1 - expected output");
//        solution.recurse("-2-(-2-1-(-2)-(-2)-(-2-2-(-2)-2)-2-2)", 0);  System.out.println("-3 16 - expected output");
//        solution.recurse("cos(3 + 19*3)", 0);  System.out.println("0.5 3 - expected output");
//        solution.recurse("2*(589+((2454*0.1548/0.01*(-2+9^2))+((25*123.12+45877*25)+25))-547)", 0);  System.out.println("8302231.36 14 - expected output");
//        solution.recurse("(-1 + (-2))", 0);  System.out.println("-3 3 - expected output");
//        solution.recurse("-sin(2*(-5+1.5*4)+28)", 0);  System.out.println("-0.5 7 - expected output");
//        solution.recurse("sin(100)-sin(100)", 0);  System.out.println("0 3 - expected output");
//        solution.recurse("-(-22+22*2)", 0);  System.out.println("-22 4 - expected output");
//        solution.recurse("-2^(-2)", 0);  System.out.println("-0.25 3 - expected output");
//        solution.recurse("-(-2^(-2))+2+(-(-2^(-2)))", 0);  System.out.println("2.5 10 - expected output");
//        solution.recurse("(-2)*(-2)", 0);  System.out.println("4 3 - expected output");
//        solution.recurse("(-2)/(-2)", 0);  System.out.println("1 3 - expected output");
//        solution.recurse("sin(-30)", 0);  System.out.println("-0.5 2 - expected output");
//        solution.recurse("cos(-30)", 0);  System.out.println("0.87 2 - expected output");
//        solution.recurse("tan(-30)", 0);  System.out.println("-0.58 2 - expected output");
//        solution.recurse("2+8*(9/4-1.5)^(1+1)", 0);  System.out.println("6.5 6 - expected output");
//        solution.recurse("0.005", 0);  System.out.println("0.01 0 - expected output");
//        solution.recurse("0.0049", 0);  System.out.println("0 0 - expected output");
//        solution.recurse("0+0.304", 0);  System.out.println("0.3 1 - expected output");
//        solution.recurse("sin(45) - cos(45)", 0);  System.out.println("0 3 - expected output");
//        solution.recurse("0/(-3)", 0);  System.out.println("0 2 - expected output");
    }

    public void recurse(final String expression, int countOperation) {
        //подчищаем строку - удаляем пробелы, внешние скобки, +-
        String newExp = clearSpace(expression);

        boolean isNumber = false;
        double end = 0.0;
        // парсим число
        try {
             end = Double.parseDouble(newExp);
            isNumber = true;
        } catch (NumberFormatException e) {
        }
        //если уже число выводим
        if (isNumber) {
            BigDecimal bigDecimal = new BigDecimal(end).setScale(2, RoundingMode.HALF_EVEN);
            DecimalFormat format = new DecimalFormat("#.##");
            System.out.println(String.format("%s %d", format.format(end),countOperation));
            return;
        }

        //ищем последние скобки ()
        int leftBracket = lastParentheses(newExp);
        int rightBracket;
        //если скобок нет, то вычисляем выражение
        String subExp;
        if (leftBracket == -1) {
            subExp = newExp;
            leftBracket = 0;
            rightBracket = subExp.length();
        }
        //или отправляем выражение в скобках
        else {
            rightBracket = newExp.indexOf(")", leftBracket);
            subExp = newExp.substring(leftBracket,rightBracket);
            newExp = newExp.substring(0,leftBracket) + subExp + newExp.substring(rightBracket+1);
        }



        recurse(newExp,countOperation);
    }

    private String clearSpace(String s){
        // подчищаем пробелы
        String newExp = s.trim()
                .replaceAll(" ","")
                .replaceAll("\\+-|--|-\\+","-");
        // удаляем наружные скобки
        if (newExp.startsWith("(") && newExp.endsWith(")")) newExp = newExp.substring(1,s.length()-2);
        return newExp;
    }

    //ищем последние скобки ()
    private int lastParentheses(String newExp){
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < newExp.length(); i++) {
            if (newExp.toCharArray()[i]=='(') stack.add(i);
        }
        if (stack.empty()) return -1;
        return stack.peek();
    }

    //вычисление выражения
    private String calculateExpression (String newExp){
        return "qqq";
    }

    public Solution() {
        //don't delete
    }
}
