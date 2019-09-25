package com.javarush.task.task22.task2209;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Graf {
    public List<String> words = new ArrayList<>();//исходный набор слов
    public List<Integer> bestChain = new ArrayList<>();// лучшая (самая длинная) найденная цепь
    public List<String> chain = new ArrayList<>();// текущая цепь во время вычислений
    public List<Boolean> wordInChain = new ArrayList<>(); //маркер использования слова в цепи
    int count = 0;

    public Graf(String... words) {
        for (String s: words){
            this.words.add(s);
            wordInChain.add(false);
        }
    }

    public void findBestChain(){
        Date d1 = new Date();
        for (String s:words) {
            findNextElement(s);
        }
        Date d2 = new Date();
        System.out.println(d2.getTime() - d1.getTime());
    }

    public void findNextElement (String s){
        wordInChain.set(words.indexOf(s), true); // слово уже использовано
        //добавляем слово в цепь
        chain.add(s);
        count++;

        for (int i = 0; i < words.size(); i++) {
            if (wordInChain.get(i)) continue; // слово уже использовано?
            //если начало следующего слова совпадает с концом переданного в метод
            String s1 =  s.substring(s.length() - 1);
            String s2 =  words.get(i).substring(0, 1);
            if (s1.equalsIgnoreCase(s2)) {
                findNextElement(words.get(i)); //рекурсия
            }
        }
        setNewBestChain();
        wordInChain.set(words.indexOf(s), false);
        chain.remove(chain.size() - 1);
    }

    public void setNewBestChain (){
        if (chain.size() > bestChain.size()) {
            bestChain.clear();
            for (int i = 0; i < chain.size(); i++) {
                if (words.indexOf(chain.get(i))>=0) bestChain.add(words.indexOf(chain.get(i)));
            }
        }
    }

}
