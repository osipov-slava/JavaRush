package com.javarush.task.task27.task2712;

import com.javarush.task.task27.task2712.kitchen.Dish;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class ConsoleHelper {
    private static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    public static void writeMessage(String message) {
        System.out.println(message);
    }


    public static String readString() throws IOException {
        return reader.readLine();
    }

    public static List<Dish> getAllDishesForOrder() throws IOException {
        writeMessage("Введите название из списка блюд:");
        writeMessage(Dish.allDishesToString());
        List<Dish> dishList = new ArrayList<>();
        String dishName;
        do {
            dishName = readString();
            boolean dishIsExist = false;
            for (Dish d : Dish.values()) {

                if (d.name().equalsIgnoreCase(dishName)) {
                    dishList.add(Dish.valueOf(dishName));
                    writeMessage("Добавлено");
                    dishIsExist = true;
                }
            }
            if (dishName.equals("exit")) break;
            if (!dishIsExist) writeMessage("Такого блюда не существует! (exit - выход)");
        } while (true);

        return dishList;
    }
}
