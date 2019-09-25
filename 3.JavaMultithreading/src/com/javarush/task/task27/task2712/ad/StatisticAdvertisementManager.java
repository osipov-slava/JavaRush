package com.javarush.task.task27.task2712.ad;

import java.util.List;
import java.util.stream.Collectors;

public class StatisticAdvertisementManager {
    private static StatisticAdvertisementManager instance;
    private AdvertisementStorage storage;

    private StatisticAdvertisementManager() {
        storage = AdvertisementStorage.getInstance();
    }

    public static StatisticAdvertisementManager getInstance() {
        if (instance == null) instance = new StatisticAdvertisementManager();

        return instance;
    }

    public List<Advertisement> getActiveVideo() {
        return storage.list().stream()
                .filter((p) -> p.getHits() > 0)
                .collect(Collectors.toList());
    }

    public List<Advertisement> getArchivedVideo() {
        return storage.list().stream()
                .filter((p) -> p.getHits() == 0)
                .collect(Collectors.toList());
    }
}
