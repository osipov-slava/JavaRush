package com.javarush.task.task27.task2712;

import com.javarush.task.task27.task2712.ad.Advertisement;
import com.javarush.task.task27.task2712.ad.StatisticAdvertisementManager;
import com.javarush.task.task27.task2712.statistic.StatisticManager;

import java.text.SimpleDateFormat;
import java.util.*;

public class DirectorTablet {
    StatisticManager statisticManager = StatisticManager.getInstance();
    StatisticAdvertisementManager statisticAdvertisementManager = StatisticAdvertisementManager.getInstance();
    static SimpleDateFormat formatter = new SimpleDateFormat("dd-MMM-yyyy", Locale.ENGLISH);

    public void printAdvertisementProfit() {
        Map<Long, Double> map = statisticManager.sumPerDay();

        Double total = 0.0;
        ArrayList<Long> keyList = new ArrayList(map.keySet());
        for (int i = keyList.size() - 1; i >= 0; i--) {
            Long key = keyList.get(i);
            total += map.get(key);
            double minutes = map.get(key);
            ConsoleHelper.writeMessage(String.format(Locale.ENGLISH, "%s - %.2f", formatter.format(new Date(key)), minutes));
        }
        if (total > 0) {
            ConsoleHelper.writeMessage(String.format(Locale.ENGLISH, "Total - %.2f", total));
        }
    }

    public void printCookWorkloading() {
        Map<Long, Map<String, Integer>> map = statisticManager.workPerDay();
        int total = 0;
        ArrayList<Long> keyList = new ArrayList(map.keySet());
        for (int i = keyList.size() - 1; i >= 0; i--) {
            Long key = keyList.get(i);
            Map<String, Integer> innerMap = map.get(key);
            Date d = new Date();
            ConsoleHelper.writeMessage(formatter.format(new Date(key)));
            for (Map.Entry<String, Integer> pair : innerMap.entrySet()) {
                ConsoleHelper.writeMessage(String.format("%s - %d min", pair.getKey(), pair.getValue() / 60)); //округлить в большую сторону?
            }
        }
    }

    public void printActiveVideoSet() {

        List<Advertisement> activeVideo = statisticAdvertisementManager.getActiveVideo();
        activeVideo.stream()
                .sorted(((o1, o2) -> o1.getName().compareToIgnoreCase(o2.getName())))
                .forEach(p -> ConsoleHelper.writeMessage(p.getName() + " - " + p.getHits()));
    }

    public void printArchivedVideoSet() {
        List<Advertisement> archivedVideo = statisticAdvertisementManager.getArchivedVideo();
        archivedVideo.stream()
                .sorted(((o1, o2) -> o1.getName().compareToIgnoreCase(o2.getName())))
                .forEach(p -> ConsoleHelper.writeMessage(p.getName()));

    }
}
