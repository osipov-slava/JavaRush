package com.javarush.task.task33.task3310;

import com.javarush.task.task33.task3310.strategy.*;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

public class Solution {
    public static void main(String[] args) {

        testStrategy(new HashMapStorageStrategy(), 10000L);
        testStrategy(new OurHashMapStorageStrategy(), 10000L);
//        testStrategy(new FileStorageStrategy(), 1000L);
        testStrategy(new OurHashBiMapStorageStrategy(), 10000L);
        testStrategy(new HashBiMapStorageStrategy(), 10000L);
        testStrategy(new DualHashBidiMapStorageStrategy(), 10000L);
    }

    public static Set<Long> getIds(Shortener shortener, Set<String> strings){
        Set<Long> longSet = new HashSet<>();
        for (String str: strings) {
            longSet.add(shortener.getId(str));
        }
        return longSet;
    }

    public static Set<String> getStrings(Shortener shortener, Set<Long> keys){
        Set<String> stringSet = new HashSet<>();
        for (Long key: keys) {
            stringSet.add(shortener.getString(key));
        }
        return stringSet;
    }

    public static void testStrategy(StorageStrategy strategy, long elementsNumber){
        Helper.printMessage(strategy.getClass().getSimpleName());

        Set<String> stringSet = new HashSet<>();
        for (int i = 0; i < elementsNumber; i++) {
            stringSet.add(Helper.generateRandomString());
        }

        Shortener shortener = new Shortener(strategy);

        Date dateBegin = new Date();
        Set<Long> longSet = new HashSet<>();
        longSet = getIds(shortener, stringSet);
        Date dateEnd = new Date();
        Helper.printMessage("" + (dateEnd.getTime() - dateBegin.getTime()));

        dateBegin = new Date();
        Set<String> stringSet1 = new HashSet<>();
        stringSet1 = getStrings(shortener, longSet);
        dateEnd = new Date();
        Helper.printMessage("" + (dateEnd.getTime() - dateBegin.getTime()));

        if (stringSet.equals(stringSet1)){
            Helper.printMessage("Тест пройден.");
        } else Helper.printMessage("Тест не пройден.");

    }
}
