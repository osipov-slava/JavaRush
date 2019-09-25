package com.javarush.task.task37.task3707;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.*;

public class AmigoSet<E> extends AbstractSet implements Set, Serializable, Cloneable {
    private static final Object PRESENT = new Object();
    private transient HashMap<E, Object> map;

    public AmigoSet() {
        map = new HashMap<>(16);
    }

    public AmigoSet(Collection<? extends E> collection) {
        int capacity = Math.max(16, (int)(collection.size()/.75f)+1);
        map = new HashMap<>(capacity);
        addAll(collection);

    }

    @Override
    public boolean add(Object o) {
        if (map.containsKey((E) o)) return false;
        else {
            map.put((E)o,PRESENT);
            return true;
        }
    }

    @Override
    public Iterator <E> iterator() {
        Set<E> setKeys = map.keySet();
        return setKeys.iterator();
    }

    @Override
    public int size() {
        return map.size();
    }

    @Override
    public boolean isEmpty() {
        return map.isEmpty();
    }

    @Override
    public boolean contains(Object o) {
        return map.containsKey((E)o);
    }

    @Override
    public boolean remove(Object o) {
        if (contains(o)) {
            map.remove((E)o);
            return true; 
        }
        else return false;
    }

    @Override
    public void clear() {
        map.clear();
    }

    @Override
    public Object clone() {
        try {
            AmigoSet<E> clone = new AmigoSet<>();
            clone.map = (HashMap) map.clone();
            return clone;
        } catch (Exception e) {
            throw new InternalError();
        }
    }

    private void writeObject(ObjectOutputStream out) throws IOException {
        out.defaultWriteObject();
        out.writeInt(HashMapReflectionHelper.<Integer>callHiddenMethod(map,"capacity"));
        out.writeFloat(HashMapReflectionHelper.<Float>callHiddenMethod(map,"loadFactor"));
        out.writeInt(map.size());
        for (E e: map.keySet()) {
            out.writeObject(e);
        }

    }

    private void readObject(ObjectInputStream in) throws IOException {
        try {
            in.defaultReadObject();
            int capacity = in.readInt();
            float loadFactor = in.readFloat();
            int size = in.readInt();
            map = new HashMap<>(capacity, loadFactor);
            for (int i = 0; i < size; i++) {
                map.put((E) in.readObject(),PRESENT);
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }


    }

}
