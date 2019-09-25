package com.javarush.task.task30.task3012;

/* 
Получи заданное число
*/

public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.createExpression(1234);
    }

    public void createExpression(int number) {
        String s1 = Integer.toString(number, 3);
        String[] base3 = s1.split("");
        String res = "";
        for (int i = 0; i < base3.length; i++) {
            if (base3[base3.length - i - 1].equals("2")) {
                res += " - " + (int) Math.pow(3, i) + " + " + (int) Math.pow(3, i + 1);
            } else if (base3[base3.length - i - 1].equals("1")) {
                res += " + " + (int) Math.pow(3, i);
            }
        }
        for (int i = 0; i < 7; i++) {
            String s = " + " + (int) Math.pow(3, i) + " - " + (int) Math.pow(3, i);
            res = res.replace(s, "");
            s = " + " + (int) Math.pow(3, i) + " + " + (int) Math.pow(3, i);
            String replace = " - " + (int) Math.pow(3, i) + " + " + (int) Math.pow(3, i + 1);
            res = res.replace(s, replace);
        }
        System.out.println(number + " =" + res);
    }
}