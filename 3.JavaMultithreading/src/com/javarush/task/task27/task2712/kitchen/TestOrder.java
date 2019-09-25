package com.javarush.task.task27.task2712.kitchen;

import com.javarush.task.task27.task2712.Tablet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public class TestOrder extends Order {

    @Override
    protected void initDishes() throws IOException {
        Set<Dish> dishes = new HashSet<>();
        int countDishes = (int) (Math.random() * Dish.values().length) + 3;
        for (int i = 0; i < countDishes; i++) {
            Dish[] arr = Dish.values();
            dishes.add(arr[(int) (Math.random() * Dish.values().length)]);
        }
        this.dishes = new ArrayList<>();
        for (Dish d: dishes) {
            this.dishes.add(d);
        }
    }

    public TestOrder(Tablet tablet) throws IOException {
        super(tablet);
    }
}
