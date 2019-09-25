package com.javarush.task.task27.task2712.ad;

import com.javarush.task.task27.task2712.ConsoleHelper;
import com.javarush.task.task27.task2712.statistic.StatisticManager;
import com.javarush.task.task27.task2712.statistic.event.VideoSelectedEventDataRow;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class AdvertisementManager {
    private int timeSeconds;
    private final AdvertisementStorage storage = AdvertisementStorage.getInstance();
    private List<Advertisement> storageList = new ArrayList<>();

    //список списков с максимальной стоимостью - если их несколько, или один список в списке
    List<List<Advertisement>> listOfLists = new ArrayList<>();

    public AdvertisementManager(int timeSeconds) {

        this.timeSeconds = timeSeconds;
        storageList = storage.list();
    }

    public void processVideos() throws NoVideoAvailableException {
        List<Advertisement> videos = new ArrayList<>();//список видео с количеством доступных просмотров > 0
        List<Advertisement> videosForViewing = new ArrayList<>();// видео готовые для показа

        //сократить список до доступных видео к просмотру
        for (Advertisement adv : storageList) {
            if (adv.getHits() > 0) videos.add(adv);
        }

        if (videos.isEmpty()) throw new NoVideoAvailableException();

        findNextElement(0, videos, new ArrayList<>());//Находим списки с максимальной выгодой
        selectListsMaxAmount();//отбираем комбинации с длительностью <= timeSeconds и максимальной суммой

        //находим список по условию 4
        if (listOfLists.isEmpty()) return;
        else if (listOfLists.size() > 1) {
            selectList1();
            if (listOfLists.size() > 1) {
                selectList2();
            }
        }
        videosForViewing = listOfLists.get(0);


            sortingList(videosForViewing);//отсортировать список по 2 требованиям
            long sumProfit = 0;
            int sumDuration = 0;
            for (Advertisement a: videosForViewing) {
                sumProfit += a.getAmountPerOneDisplaying();
                sumDuration += a.getDuration();
            }
            //регистрируем событие
            StatisticManager.getInstance().register(
                    new VideoSelectedEventDataRow(
                            videosForViewing,
                            sumProfit,
                            sumDuration));
            //вывод рекламы
            for (Advertisement adv : videosForViewing) {
                ConsoleHelper.writeMessage(adv.toString());
                adv.revalidate();
            }

    }

    private void findNextElement(int n, List<Advertisement> videos,
                                 List<Advertisement> listSearch) {

        if (n == videos.size()) return;
        for (int i = n; i < videos.size(); i++) {
            listSearch.add(videos.get(i));//добавляем элемент в текущий список
            List<Advertisement> newList = new ArrayList<Advertisement>();//записываем, найденную комбинацию
            listOfLists.add(newList);
            for (Advertisement a : listSearch) {
                newList.add(a);
            }
            findNextElement(i + 1, videos, listSearch);//рекурсия
            listSearch.remove(listSearch.size() - 1);
        }
    }

    private void selectListsMaxAmount() {

        List<List<Advertisement>> tempList = new ArrayList<>();
        int maxAmount = 0;
        for (List<Advertisement> list : listOfLists) {
            int sumAmount = 0;
            int sumDuration = 0;
            for (Advertisement a : list) {
                sumAmount += a.getAmountPerOneDisplaying();
                sumDuration += a.getDuration();
            }
            //если найден новый максимум
            if (sumAmount > maxAmount && sumDuration <= timeSeconds) {
                maxAmount = sumAmount;
                tempList.clear();
                tempList.add(new ArrayList<Advertisement>());
                for (Advertisement a : list) {
                    tempList.get(0).add(a);
                }
            }
            //если повторно найдена максимальная сумма
            else if (sumAmount == maxAmount) {
                tempList.add(new ArrayList<Advertisement>());
                for (Advertisement a : list) {
                    tempList.get(tempList.size() - 1).add(a);
                }
            }
        }
        listOfLists = tempList;
    }

    //находим список по условию 4.1
    private void selectList1() {

        List<List<Advertisement>> tempList = new ArrayList<>();
        int timeMax = 0;
        //находим максимальную длительность
        for (List<Advertisement> list : listOfLists) {
            int time = 0;
            for (Advertisement a : list) {
                time += a.getDuration();
            }
            //если найден новый максимум
            if (time > timeMax && time <= timeSeconds) {
                timeMax = time;
                tempList.clear();
                tempList.add(list);
            }
            //если найдено такое же значение
            else if (time == timeMax) {
                tempList.add(list);
            }
        }
        listOfLists = tempList;
    }

    //находим список по условию 4.2
    private void selectList2() {
        List<List<Advertisement>> tempList = new ArrayList<>();
        int countMin = Integer.MAX_VALUE;
        //находим максимальное количество роликов
        for (List<Advertisement> list : listOfLists) {
            //если найден новый максимум
            if (list.size() < countMin) {
                countMin = list.size();
                tempList.clear();
                tempList.add(list);
            }
            else if (list.size() == countMin) {
                tempList.add(list);
            }
        }
        listOfLists = tempList;
    }

    private static class CustomizedComparator<T> implements Comparator<T> {
        private Comparator<T>[] comparators;

        public CustomizedComparator(Comparator<T>... vararg) {
            this.comparators = vararg;
        }

        @Override
        public int compare(T o1, T o2) {
            int result = 0;
            for (Comparator comparator : comparators) {
                result = comparator.compare(o1, o2);
                if (result != 0) break;
            }
            return result;
        }
    }

    Comparator<Advertisement> comparator1 = new Comparator<Advertisement>() {
        @Override
        public int compare(Advertisement o1, Advertisement o2) {
            Long l1 = o1.getAmountPerOneDisplaying();
            Long l2 = o2.getAmountPerOneDisplaying();
            return l2.compareTo(l1);//возрастание?
        }
    };

    Comparator<Advertisement> comparator2 = new Comparator<Advertisement>() {
        @Override
        public int compare(Advertisement o1, Advertisement o2) {
            Long l1 = o1.getAmount1Second1000();
            Long l2 = o2.getAmount1Second1000();
            return l1.compareTo(l2);//убывание?
        }
    };

    //отсортировать список по 2 требованиям
    private void sortingList(List<Advertisement> list) {
        CustomizedComparator<Advertisement> customizedComparator
                = new CustomizedComparator<>(comparator1, comparator2);
        Collections.sort(list, customizedComparator);
    }
}
