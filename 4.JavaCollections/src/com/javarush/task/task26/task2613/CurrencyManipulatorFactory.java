package com.javarush.task.task26.task2613;

import java.util.*;

public class CurrencyManipulatorFactory {
    private static Map<String, CurrencyManipulator> map = new HashMap<>();
    private static CurrencyManipulatorFactory factory;

    private CurrencyManipulatorFactory() {
    }

    public static CurrencyManipulatorFactory getInstance() {
        if (factory == null) factory = new CurrencyManipulatorFactory();
        return factory;
    }

    public static CurrencyManipulator getManipulatorByCurrencyCode(String currencyCode) {
        currencyCode = currencyCode.toUpperCase();
        if (map.containsKey(currencyCode))
            return map.get(currencyCode);
        else {
            map.put(currencyCode, new CurrencyManipulator(currencyCode));
            return map.get(currencyCode);
        }
    }

    public static Collection<CurrencyManipulator> getAllCurrencyManipulators(){
        Set<CurrencyManipulator> set = new HashSet<>();
        for (Map.Entry<String, CurrencyManipulator> entry: map.entrySet()) {
            set.add(entry.getValue());
        }
        return set;
    }
}
