package com.javarush.task.task16.task1632;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Solution {
    public static List<Thread> threads = new ArrayList<>(5);

    static {
        threads.add(new Thread1());
        threads.add(new Thread2());
        threads.add(new Thread3());
        threads.add(new Thread4());
        threads.add(new Thread5());
    }

    public static void main(String[] args) {
        for (int i=0 ; i<5; i++) threads.get(i).start();



    }

    public static class Thread1 extends Thread{
        @Override
        public void run() {
            while (true) {

            }
        }
    }

    public static class Thread2 extends Thread{
        @Override
        public void run() {
            try {
                while (true){
                    Thread.sleep(1000);
                }
            } catch (InterruptedException e) {
                System.out.println("InterruptedException");
            }
        }
    }

    public static class Thread3 extends Thread{
        @Override
        public void run() {
            while (true) {
                try {
                    System.out.println("Ура");
                    Thread.sleep(500);
                } catch (InterruptedException e) {

                }


            }

        }
    }

    public static class Thread4 extends Thread implements Message{
        @Override
        public void run() {
            while (!isInterrupted()) {
            }
        }

        @Override
        public void showWarning() {
            this.interrupt();
        }
    }

    public static class Thread5 extends Thread{
        @Override
        public void run() {
            int a = 0;
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            do {
                try {
                    String str = reader.readLine();
                    if ("N".equals(str)) {
                        System.out.println(a);
                        break;
                    }
                    a += Integer.parseInt(str);
                } catch (IOException e) {
                    System.out.println("Введите целое число");
                }
            } while (true);

        }
    }
}