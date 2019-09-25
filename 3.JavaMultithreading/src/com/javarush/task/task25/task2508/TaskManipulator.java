package com.javarush.task.task25.task2508;

public class TaskManipulator implements Runnable, CustomThreadManipulator {
    private Thread thread;

    @Override
    public void run() {
        while (!Thread.currentThread().isInterrupted()) {
            try {
                System.out.println(thread.getName());
                Thread.currentThread().sleep(100);

            } catch (InterruptedException e) {

                Thread.currentThread().interrupt();
            }
        }

    }

//    Метод start должен создавать, сохранять во внутреннее поле и запускать
//    нить с именем, которое передано через аргумент метода.
    @Override
    public void start(String threadName) {
        thread = new Thread(this, threadName);
        thread.start();
    }

//    Метод stop должен прерывать последнюю созданную классом TaskManipulator нить.
    @Override
    public void stop() {
        thread.interrupt();
    }
}
