package com.javarush.task.task25.task2504;

/* 
Switch для нитей
*/
public class Solution {
    public static void processThreads(Thread... threads) {
        //implement this method - реализуйте этот метод
        for (Thread thread : threads) {
            switch (thread.getState()) {
                case NEW: {thread.start(); break;}

                case TIMED_WAITING:
                case BLOCKED:
                case WAITING: {thread.interrupt(); break;}

                case RUNNABLE: {thread.isInterrupted(); break;}
                case TERMINATED: {
                    System.out.println(thread.getPriority());
                    break;}

            }
        }
    }

    public static void main(String[] args) {
        Thread thread1 = new Thread();
        Thread thread2 = new Thread();
        thread2.start();
        processThreads(thread1, thread2);
    }
}
