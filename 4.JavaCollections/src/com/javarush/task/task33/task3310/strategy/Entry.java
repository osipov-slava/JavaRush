package com.javarush.task.task33.task3310.strategy;

import java.io.Serializable;
import java.util.Objects;

public class Entry implements Serializable {
    private static final long serialVersionUID = 12345L;

    Long key;
    String value;
    Entry next;
    int hash;

    public Entry(int hash, Long key, String value, Entry next){
        this.hash = hash;
        this.key = key;
        this.value = value;
        this.next = next;
    }

    public Long getKey(){
        return key;
    }

    public String getValue(){
        return value;
    }

    @Override
    public int hashCode(){
        return Objects.hash(key, value);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this)
            return true;
        if (obj instanceof Entry) {
            if (((Entry) obj).key.equals(key)
                && ((Entry) obj).value.equals(value))
                return true;
        }
        return false;
    }

    @Override
    public String toString(){
        return key + "=" + value;
    }

}
