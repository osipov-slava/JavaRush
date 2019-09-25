package com.javarush.task.task27.task2712.kitchen;

import com.javarush.task.task27.task2712.ConsoleHelper;
import com.javarush.task.task27.task2712.statistic.StatisticManager;
import com.javarush.task.task27.task2712.statistic.event.CookedOrderEventDataRow;

import java.util.Observable;
import java.util.concurrent.LinkedBlockingQueue;

public class Cook extends Observable implements Runnable{
    private LinkedBlockingQueue<Order> queue;

    private String name;

    public Cook(String name) {

        this.name = name;
    }

    @Override
    public void run() {
        StatisticManager statisticEventManager = StatisticManager.getInstance();
        while (true) {
            if (queue.size() > 0) {
                startCookingOrder(queue.poll());
            }
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {

            }
        }
    }


    public void setQueue(LinkedBlockingQueue<Order> orderQueue) {
        this.queue = orderQueue;
    }

    @Override
    public String toString() {
        return name;
    }

    public void startCookingOrder(Order order){
        ConsoleHelper.writeMessage("Start cooking - " + order + ", cooking time " + ((Order) order).getTotalCookingTime() + "min");
        setChanged();
        notifyObservers(order);
        try {
            Thread.sleep(10*order.getTotalCookingTime());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        StatisticManager.getInstance().register(
                new CookedOrderEventDataRow(this.toString(),
                        name,
                        ((Order) order).getTotalCookingTime()*60,
                        ((Order) order).getDishes()));
    }

}
