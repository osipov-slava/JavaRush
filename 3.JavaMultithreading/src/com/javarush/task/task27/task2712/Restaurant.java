package com.javarush.task.task27.task2712;

import com.javarush.task.task27.task2712.kitchen.Cook;
import com.javarush.task.task27.task2712.kitchen.Order;
import com.javarush.task.task27.task2712.kitchen.Waiter;
import com.javarush.task.task27.task2712.statistic.StatisticManager;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.LinkedBlockingQueue;

public class Restaurant {
    private static final int ORDER_CREATING_INTERVAL = 100;
    private static final LinkedBlockingQueue<Order> orderQueue = new LinkedBlockingQueue<>();

    public static void main(String[] args) {
        Waiter waiter = new Waiter();
        List<Tablet> tablets = new ArrayList<>();

        Cook cook1 = new Cook("Mr.Backer");
        cook1.setQueue(orderQueue);
        StatisticManager.getInstance().register(cook1);
        cook1.addObserver(waiter);

        Cook cook2 = new Cook("Mr.John");
        cook2.setQueue(orderQueue);
        StatisticManager.getInstance().register(cook2);
        cook2.addObserver(waiter);

        for (int i = 0; i < 5; i++) {
            Tablet t = new Tablet(i);
            t.setQueue(orderQueue);
            tablets.add(t);
        }

        RandomOrderGeneratorTask generatorTask = new RandomOrderGeneratorTask(tablets, ORDER_CREATING_INTERVAL);
        Thread thread1 = new Thread(generatorTask);
        Thread thread2 = new Thread(cook1);
        Thread thread3 = new Thread(cook2);
        thread2.setDaemon(true);
        thread3.setDaemon(true);

        thread1.start();
        thread2.start();
        thread3.start();

        try {
            Thread.currentThread().join(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        thread1.interrupt();

        DirectorTablet directorTablet = new DirectorTablet();
        directorTablet.printActiveVideoSet();
        directorTablet.printAdvertisementProfit();
        directorTablet.printArchivedVideoSet();
        directorTablet.printCookWorkloading();
    }
}
