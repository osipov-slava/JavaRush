package com.javarush.task.task36.task3610;

import java.io.Serializable;
import java.util.*;

public class MyMultiMap<K, V> extends HashMap<K, V> implements Cloneable, Serializable {
    static final long serialVersionUID = 123456789L;
    private HashMap<K, List<V>> map;
    private int repeatCount;

    public MyMultiMap(int repeatCount) {
        this.repeatCount = repeatCount;
        map = new HashMap<>();
    }

    @Override
    public int size() {
        int count = 0;
        for (List<V> list : map.values()) {
            count += list.size();
        }
        return count;
    }

    @Override
    public V put(K key, V value) {
        //если ключа еще нет
        if (!map.keySet().contains(key)) {
            map.put(key, new ArrayList<V>());
            map.get(key).add(value);
            return null;
        }
        //если ключ есть
        //и колво элементов меньше repeatCount
        if (map.get(key).size() < repeatCount) {
            map.get(key).add(value);
            //если колво элементов = repeatCount
        } else {
            map.get(key).remove(0);
            map.get(key).add(value);
        }
        return map.get(key).get(map.get(key).size() - 2);
    }

    @Override
    public V remove(Object key) {
        if (!map.containsKey(key)) return null;
        if (map.get(key).size()==0) {
            map.remove(key);
            return null;
        }
        V removedElement = map.get(key).get(0);
        map.get(key).remove(0);
        if (map.get(key).size() == 0) map.remove(key);
        return removedElement;
    }

    @Override
    public Set<K> keySet() {
        return map.keySet();
    }

    @Override
    public Collection<V> values() {
        ArrayList<V> arrayList = new ArrayList<>();
        for (List<V> list : map.values()) {
            arrayList.addAll(list);
        }
        return arrayList;
    }

    @Override
    public boolean containsKey(Object key) {
        return map.containsKey(key);
    }

    @Override
    public boolean containsValue(Object value) {
        for (List<V> list : map.values()) {
            if (list.contains(value)) return true;
        }
        return false;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("{");
        for (Map.Entry<K, List<V>> entry : map.entrySet()) {
            sb.append(entry.getKey());
            sb.append("=");
            for (V v : entry.getValue()) {
                sb.append(v);
                sb.append(", ");
            }
        }
        String substring = sb.substring(0, sb.length() - 2);
        return substring + "}";
    }
}