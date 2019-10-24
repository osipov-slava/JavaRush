package com.javarush.task.task33.task3310.tests;

import com.javarush.task.task33.task3310.Helper;
import com.javarush.task.task33.task3310.Shortener;
import com.javarush.task.task33.task3310.strategy.HashBiMapStorageStrategy;
import com.javarush.task.task33.task3310.strategy.HashMapStorageStrategy;
import org.junit.Assert;
import org.junit.Test;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

public class SpeedTest {
    public long getTimeToGetIds(Shortener shortener, Set<String> strings, Set<Long> ids) {
        Date dateBegin = new Date();
        for (String s : strings) {
            ids.add(shortener.getId(s));
        }
        Date dateEnd = new Date();
        return dateEnd.getTime() - dateBegin.getTime();
    }

    public long getTimeToGetStrings(Shortener shortener, Set<Long> ids, Set<String> strings) {
        Date dateBegin = new Date();
        for (Long l : ids) {
            strings.add(shortener.getString(l));
        }
        Date dateEnd = new Date();
        return dateEnd.getTime() - dateBegin.getTime();
    }

    @Test
    public void testHashMapStorage() {
        Shortener shortener1 = new Shortener(new HashMapStorageStrategy());
        Shortener shortener2 = new Shortener(new HashBiMapStorageStrategy());
        Set<String> origStrings = new HashSet<>();
        for (int i = 0; i < 10000; i++) {
            origStrings.add(Helper.generateRandomString());
        }

        long t1 = getTimeToGetIds(shortener1, origStrings, new HashSet<Long>());
        long t2 = getTimeToGetIds(shortener2, origStrings, new HashSet<Long>());
        Assert.assertTrue(t1 > t2);

        Set<Long> ids1 = new HashSet<>();
        for (String s : origStrings) {
            ids1.add(shortener1.getId(s));
        }
        Set<Long> ids2 = new HashSet<>();
        for (String s : origStrings) {
            ids2.add(shortener2.getId(s));
        }

        t1 = getTimeToGetStrings(shortener1, ids1, new HashSet<String>());
        t2 = getTimeToGetStrings(shortener2, ids2, new HashSet<String>());

        Assert.assertEquals((float) t1, (float) t2, 30);
    }
}
