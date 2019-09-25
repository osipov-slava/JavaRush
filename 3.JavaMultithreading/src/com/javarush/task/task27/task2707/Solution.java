package com.javarush.task.task27.task2707;


/*
Определяем порядок захвата монитора
*/
public class Solution {
    public void someMethodWithSynchronizedBlocks(Object obj1, Object obj2) {
        synchronized (obj1) {
            synchronized (obj2) {
                System.out.println(obj1 + " " + obj2);
            }
        }
    }

    public static boolean isLockOrderNormal(final Solution solution, final Object o1, final Object o2) throws Exception {
        synchronized (o1){
            Runnable runnable1 = new Runnable(){
                @Override
                public void run() {
                    solution.someMethodWithSynchronizedBlocks(o1, o2);
                }
            };
            Thread thread1 = new Thread(runnable1);
            thread1.start();

            Thread.sleep(50);//Ждем чтобы гарантированно запустился 1 поток

            Runnable runnable2 = new Runnable(){
                @Override
                public void run() {
                    synchronized (o2){
                        try {
                            Thread.sleep(100);// чтобы успеть диагностировать, что объект захвачен
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }
            };
            Thread thread2 = new Thread(runnable2);
            thread2.start();
            Thread.sleep(50); // чтобы гарантировать, что поток 2 запущен
            if (thread2.getState() == Thread.State.BLOCKED) return false;
            else return true;
        }
    }

    public static void main(String[] args) throws Exception {
        final Solution solution = new Solution();
        final Object o1 = new Object();
        final Object o2 = new Object();

        System.out.println(isLockOrderNormal(solution, o1, o2));
    }
}
