package com.javarush.task.task27.task2712.statistic;

import com.javarush.task.task27.task2712.ad.Advertisement;
import com.javarush.task.task27.task2712.kitchen.Cook;
import com.javarush.task.task27.task2712.kitchen.Dish;
import com.javarush.task.task27.task2712.statistic.event.CookedOrderEventDataRow;
import com.javarush.task.task27.task2712.statistic.event.EventDataRow;
import com.javarush.task.task27.task2712.statistic.event.EventType;
import com.javarush.task.task27.task2712.statistic.event.VideoSelectedEventDataRow;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.*;

import static com.javarush.task.task27.task2712.statistic.event.EventType.COOKED_ORDER;
import static com.javarush.task.task27.task2712.statistic.event.EventType.NO_AVAILABLE_VIDEO;
import static com.javarush.task.task27.task2712.statistic.event.EventType.SELECTED_VIDEOS;

public class StatisticManager {
    private static StatisticManager ourInstance;
    private StatisticStorage statisticStorage = new StatisticStorage();
    private Set<Cook> cooks = new HashSet<>();

    public static StatisticManager getInstance() {
        if (ourInstance == null) {
            ourInstance = new StatisticManager();
        }
        return ourInstance;
    }

    private StatisticManager() {
    }

    public void register(EventDataRow data) {
        statisticStorage.put(data);

    }

    public void register(Cook cook) {
        cooks.add(cook);
    }

    public Map<Long, Double> sumPerDay() {
        Map<Long, Double> map = new TreeMap<>();

        for (EventDataRow event : statisticStorage.get(SELECTED_VIDEOS)) {
            LocalDate ld = convertToLocalDate(event.getDate());
            Date d1 = convertToDate(ld);
            Long day = d1.getTime();

            if (map.containsKey(day)) {
                map.put(day, map.get(day) + ((VideoSelectedEventDataRow) event).getAmount()/100.0);
            } else {
                map.put(day, ((VideoSelectedEventDataRow) event).getAmount()/100.0);
            }
        }
        return map;
    }

    public Map<Long, Map<String, Integer>> workPerDay() {
        Map<Long, Map<String, Integer>> map = new TreeMap<>();

        for (EventDataRow event : statisticStorage.get(COOKED_ORDER)) {
            CookedOrderEventDataRow cookEvent = (CookedOrderEventDataRow) event;
            LocalDate ld = convertToLocalDate(event.getDate());
            Date d1 = convertToDate(ld);
            Long day = d1.getTime();

            if (map.containsKey(day)) {
                Map<String, Integer> cookMap = map.get(day);
                String cook = cookEvent.getCookName();
                if (cookMap.containsKey(cook)){
                    cookMap.put(cook, cookEvent.getTime() + cookMap.get(cook));
                }
                else {
                    cookMap.put(cook, cookEvent.getTime());
                }

            } else {
                Map<String, Integer> cookMap = new TreeMap<String, Integer>();
                cookMap.put(((CookedOrderEventDataRow) event).getCookName(), (cookEvent.getTime()));
                map.put(day, cookMap);
            }
        }
        return map;
    }

    public LocalDate convertToLocalDate(Date dateToConvert) {
        return dateToConvert.toInstant()
                .atZone(ZoneId.systemDefault())
                .toLocalDate();
    }

    public Date convertToDate(LocalDate dateToConvert) {
        return Date.from(dateToConvert.atStartOfDay()
                .atZone(ZoneId.systemDefault())
                .toInstant());
    }

    private class StatisticStorage {
        Map<EventType, List<EventDataRow>> storage = new HashMap<>();

        public StatisticStorage() {
            //Инициализация пустыми данными
            for (int i = 0; i < 5; i++) {
                storage.put(COOKED_ORDER, new ArrayList<EventDataRow>());
                storage.put(SELECTED_VIDEOS, new ArrayList<EventDataRow>());
                storage.put(NO_AVAILABLE_VIDEO, new ArrayList<EventDataRow>());
            }
        }

        private void put(EventDataRow data) {
            storage.get(data.getType()).add(data);
        }

        private List<EventDataRow> get(EventType type) {
            return storage.get(type);
        }
    }

    public Set<Cook> getCooks() {
        return cooks;
    }
}
