package com.javarush.task.task25.task2514;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

/*
Первый закон Финэйгла: если эксперимент удался, что-то здесь не так...
*/
public class Solution {
    public static class YieldRunnable implements Runnable {
        private int index;

        public YieldRunnable(int index) {
            this.index = index;
        }

        public void run() {
            synchronized (System.in) {
                System.out.println("begin-" + index);
                //Thread.yield();
                System.out.println("end-" + index);
            }
        }
    }

    public static void main(String[] args) {

        try {
            System.setIn(new FileInputStream("h:/test/23.txt"));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        for (int i = 1; i <= 10; i++)  {
            new Thread(new YieldRunnable(i)).start();
        }


    }
}
