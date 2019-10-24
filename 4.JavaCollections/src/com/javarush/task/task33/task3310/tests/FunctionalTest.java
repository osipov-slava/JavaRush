package com.javarush.task.task33.task3310.tests;

import com.javarush.task.task33.task3310.Shortener;
import com.javarush.task.task33.task3310.strategy.*;
import org.junit.Assert;
import org.junit.Test;

public class FunctionalTest {

    public void testStorage(Shortener shortener){
        String s1 = "string 1 or 3";
        String s2 = "string 2";
        String s3 = s1;

        long l1 = shortener.getId(s1);
        long l2 = shortener.getId(s2);
        long l3 = shortener.getId(s3);

        Assert.assertNotEquals(l1,l2);
        Assert.assertNotEquals(l3,l2);
        Assert.assertEquals(l1,l3);

        String ss1 = shortener.getString(l1);
        String ss2 = shortener.getString(l2);
        String ss3 = shortener.getString(l3);

        Assert.assertEquals(s1, ss1);
        Assert.assertEquals(s2, ss2);
        Assert.assertEquals(s3, ss3);
    }

    @Test
    public void testHashMapStorageStrategy(){
        StorageStrategy map = new HashMapStorageStrategy();
        Shortener shortener = new Shortener(map);
        testStorage(shortener);
    }

    @Test
    public void testOurHashMapStorageStrategy(){
        StorageStrategy map = new OurHashMapStorageStrategy();
        Shortener shortener = new Shortener(map);
        testStorage(shortener);
    }

    @Test
    public void testFileStorageStrategy(){
        StorageStrategy map = new FileStorageStrategy();
        Shortener shortener = new Shortener(map);
        testStorage(shortener);
    }

    @Test
    public void testHashBiMapStorageStrategy(){
        StorageStrategy map = new HashBiMapStorageStrategy();
        Shortener shortener = new Shortener(map);
        testStorage(shortener);
    }

    @Test
    public void testDualHashBidiMapStorageStrategy(){
        StorageStrategy map = new DualHashBidiMapStorageStrategy();
        Shortener shortener = new Shortener(map);
        testStorage(shortener);
    }

    @Test
    public void testOurHashBiMapStorageStrategy(){
        StorageStrategy map = new HashMapStorageStrategy();
        Shortener shortener = new Shortener(map);
        testStorage(shortener);
    }
}
