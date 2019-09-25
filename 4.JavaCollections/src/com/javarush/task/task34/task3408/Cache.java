package com.javarush.task.task34.task3408;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.util.Map;
import java.util.WeakHashMap;

public class Cache<K, V> {
    private Map<K, V> cache = new WeakHashMap<>();

    public V getByKey(K key, Class<V> clazz) throws Exception {

        if (!cache.containsKey(key)) {
            Constructor ct = clazz.getDeclaredConstructor(key.getClass());
            Object arglist[] = new Object[1];
            arglist[0] = key;
            cache.put(key, (V) ct.newInstance(arglist));
        }
        return cache.get(key);
    }

    public boolean put(V obj) {
        try {
            Class cls = obj.getClass();
            Method meth = cls.getDeclaredMethod("getKey");
            meth.setAccessible(true);
            K key = (K) meth.invoke(obj);
            cache.put(key, obj);
        }
        catch (Throwable e) {
            return false;
        }
        return true;
    }

    public int size() {
        return cache.size();
    }
}
