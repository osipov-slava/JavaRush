package com.javarush.task.task27.task2712.ad;

import java.util.ArrayList;
import java.util.List;

public class AdvertisementStorage {
    private static AdvertisementStorage ourInstance;
    private final List<Advertisement> videos = new ArrayList<>();

    public static AdvertisementStorage getInstance() {
        if (ourInstance == null) {
            ourInstance = new AdvertisementStorage();
        }
        return ourInstance;
    }

    public List<Advertisement> list(){
        return videos;
    }

    public void add(Advertisement advertisement){
        videos.add(advertisement);
    }

    private AdvertisementStorage() {
        Object someContent = new Object();                                                                        // Dur   Am Am/s
        videos.add(new Advertisement(someContent, "Первое видео", 5000, 100, 6 * 60)); // 360   50  138
        videos.add(new Advertisement(someContent, "Second Video", 1000, 10, 15 * 60));// 900   10  111
        videos.add(new Advertisement(someContent, "Третье видео", 400, 2, 8 * 60));    // 480  200  416
        videos.add(new Advertisement(someContent, "Fourth Video", 1000, 5, 9 * 60));  // 540  200  370
        videos.add(new Advertisement(someContent, "Fifth Video", 400, 8, 6 * 60));    // 360   50  138
    }

    private Object readResolve() {
        return getInstance( );
    }

}
