package com.javarush.task.task27.task2712;

import com.javarush.task.task27.task2712.ad.AdvertisementManager;
import com.javarush.task.task27.task2712.ad.NoVideoAvailableException;
import com.javarush.task.task27.task2712.kitchen.Order;
import com.javarush.task.task27.task2712.kitchen.TestOrder;

import java.io.IOException;
import java.util.Observable;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.logging.Level;
import java.util.logging.Logger;

import static java.util.logging.Level.SEVERE;

public class Tablet {
    private LinkedBlockingQueue<Order> queue;
    final int number;
    private Order order;
    private static Logger logger = Logger.getLogger(Tablet.class.getName());

    public Tablet(int number) {
        this.number = number;
    }

    public void setQueue(LinkedBlockingQueue<Order> queue) {
        this.queue = queue;
    }

    private Order getOrder() {
        if (!order.isEmpty()) {
            try {
                queue.put(order);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            ConsoleHelper.writeMessage(order.toString());
            try {
                new AdvertisementManager(order.getTotalCookingTime()*60).processVideos();
            } catch (NoVideoAvailableException e) {
                logger.log(Level.INFO, "No video is available for the order " + order);
            }
        }
        return order;
    }

    public Order createOrder() {
        try {
            order = new Order(this);
            return getOrder();
        } catch (IOException e) {
            logger.log(SEVERE, "Console is unavailable.");
            return null;
        }
    }

    public void createTestOrder(){
        try {
            order = new TestOrder(this);
            getOrder();
        } catch (IOException e) {
            logger.log(SEVERE, "Console is unavailable.");
        }
    }

    @Override
    public String toString() {
        return "Tablet{number=" + number + "}";
    }


}
