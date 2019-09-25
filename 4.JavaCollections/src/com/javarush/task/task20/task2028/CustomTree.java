package com.javarush.task.task20.task2028;

import java.io.Serializable;
import java.util.*;

/* 
Построй дерево(1)
*/
public class CustomTree extends AbstractList<String> implements Cloneable, Serializable {
    Entry<String> root;
    private List <Entry<String>> entryList = new LinkedList<>();
    private int count;

    @Override
    public boolean add(String s) {
        Entry<String> newChild = new Entry<>(s);

        //дописываем новый узел на свободную ветку
        if (!addNewChildren(root, newChild)) {
            System.out.println("Нет свободных веток!");
            return false;
        }

        count++;
        return true;
    }

    private boolean addNewChildren(Entry<String> root, Entry<String> newChild){
        Queue<Entry<String>> queue = new LinkedList<>();
        Entry<String> node = root;
        queue.offer(node);
        while ((node = queue.poll()) != null) {
            // если левая ветка свободна, присодиняем узел
            if (node.availableToAddLeftChildren) {
                node.leftChild = newChild;
                newChild.parent = node;
                node.availableToAddLeftChildren = false;
                entryList.add(newChild);
                return true;
            }
            // если не свободна, но есть соединенный узел
            else if (node.leftChild != null) {
                // добавляем узел в очередь
                queue.offer(node.leftChild);
            }
            // если правая ветка свободна, присодиняем узел
            if (node.availableToAddRightChildren) {
                node.rightChild = newChild;
                newChild.parent = node;
                node.availableToAddRightChildren = false;
                entryList.add(newChild);
                return true;
            }
            else if (node.rightChild != null) {
                queue.offer(node.rightChild);
            }
        }
// если больще нет свободных веток, восстанавливаем узлы без веток
        for (Entry<String> entry: entryList) {
            if (!entry.isAvailableToAddChildren() && entry.leftChild == null && entry.rightChild == null){
                entry.availableToAddLeftChildren = true;
                entry.availableToAddRightChildren = true;
            }
        }

        addNewChildren(root, newChild);
        return true;
    }

    @Override
    public boolean remove(Object o) {
        if (!(o instanceof String)) throw new UnsupportedOperationException();

        Entry<String> entryForRemove = getEntry((String) o);
        if (entryForRemove.parent.leftChild == entryForRemove) entryForRemove.parent.leftChild = null;
        if (entryForRemove.parent.rightChild == entryForRemove) entryForRemove.parent.rightChild = null;

        Queue<Entry<String>> queue = new LinkedList<>();
        queue.offer(entryForRemove);
        while ((entryForRemove = queue.poll()) != null) {
            if (entryForRemove.leftChild != null) {
                queue.offer(entryForRemove.leftChild);
            }
            if (entryForRemove.rightChild != null) {
                queue.offer(entryForRemove.rightChild);
            }
            entryList.remove(entryForRemove);
            count--;
        }

        return true;
    }

    private Entry<String> getEntry (String s){
        for (Entry<String> entry: entryList) {
            if (entry.elementName.equals(s)) return entry;
        }
        return null;
    }

    @Override
    public int size() {
        return count;
    }

    public String getParent(String s){
        for (Entry<String> entry: entryList) {
            if (entry.elementName.equals(s)) return entry.parent.elementName;
        }
        return null;
    }

//            2. При удалении элемента, удаляется вся ветка вместе с ним (то есть остается только
//            родитель удалённого элемента (например удаляем 3, как на рисунке. Так вот, удаляется
//            вся ветка до низу, и полям availableToAddLeftChildren и availableToAddRightChildren
//            Node-а со значением "1" присваиваются значения false, в зависимости от того есть ли
//            левый child или правый). Это реализуется с помощью метода checkChildren.
//            4. Может возникнуть ситуация когда у ни одного из Node-ов не будет возможности иметь
//    потомков. Например при удалении Node-ов со значениями "3", "4", "5", "6". Тогда у Node-а "1"
//    не будет возможности иметь ни левого, ни правого потомка (и leftChild = null и
//            rightChild = null, тогда метод chechChildren запретит возможность иметь потомков).
//    Аналогично для Node-а со значением "2". Эту ситуацию нужно предусмотреть и если она случиться,
//    добавить Node-ам "1", "2" возможность иметь потомков (так же в усл. задачи) Вот и всё)

    public CustomTree() {

        this.root = new Entry<>("Root");
        entryList.add(this.root);
    }

    @Override
    public String get(int index) {
        throw new UnsupportedOperationException();
    }

    @Override
    public String set(int index, String element) {
        throw new UnsupportedOperationException();
    }

    @Override
    public void add(int index, String element) {
        throw new UnsupportedOperationException();
    }

    @Override
    public String remove(int index) {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean addAll(int index, Collection<? extends String> c) {
        throw new UnsupportedOperationException();
    }

        @Override
    public List<String> subList(int fromIndex, int toIndex) {
        throw new UnsupportedOperationException();
    }

    @Override
    protected void removeRange(int fromIndex, int toIndex) {
        throw new UnsupportedOperationException();
    }

    static class Entry<T> implements Serializable{
        String elementName;
        boolean availableToAddLeftChildren, availableToAddRightChildren;
        Entry<T> parent, leftChild, rightChild;

        public Entry(String elementName) {
            this.elementName = elementName;
            availableToAddLeftChildren = true;
            availableToAddRightChildren = true;
        }

        public boolean isAvailableToAddChildren(){
            return (availableToAddLeftChildren || availableToAddRightChildren);
        }
    }
}
