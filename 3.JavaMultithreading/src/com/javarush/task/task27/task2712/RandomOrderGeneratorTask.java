package com.javarush.task.task27.task2712;

import java.util.LinkedList;
import java.util.List;

public class RandomOrderGeneratorTask implements Runnable {
    private List<Tablet> tablets = new LinkedList<>();
    private int interval;

    public RandomOrderGeneratorTask(List<Tablet> tablets, int interval) {
        this.tablets = tablets;
        this.interval = interval;
    }

    @Override
    public void run() {
        while (true){
            int numberTablet = (int) (Math.random() * tablets.size());
            tablets.get(numberTablet).createTestOrder();
            try {
                Thread.sleep(interval);
            } catch (InterruptedException e) {
                return;
            }
        }

    }
}


