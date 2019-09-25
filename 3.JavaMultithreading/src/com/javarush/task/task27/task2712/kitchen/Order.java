package com.javarush.task.task27.task2712.kitchen;

import com.javarush.task.task27.task2712.ConsoleHelper;
import com.javarush.task.task27.task2712.Tablet;

import java.io.IOException;
import java.util.List;

public class Order {
    private final Tablet tablet; //
    protected List<Dish> dishes; // список выбранных блюд

    protected void initDishes() throws IOException{
        dishes = ConsoleHelper.getAllDishesForOrder();
    }

    public Order(Tablet tablet) throws IOException{
        this.tablet = tablet;
        initDishes();
    }

    @Override
    public String toString() {
        if (dishes.isEmpty()) return "";
        else return "Your order: " + dishes.toString() + " of " + tablet.toString();
    }

    public boolean isEmpty(){
        return dishes.isEmpty();
    }

    public int getTotalCookingTime(){
        int sum=0;
        for (Dish d: dishes) {
            sum += d.getDuration();
        }
        return sum;
    }

    public List<Dish> getDishes() {
        return dishes;
    }
}
