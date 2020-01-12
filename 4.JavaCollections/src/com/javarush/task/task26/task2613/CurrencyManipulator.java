package com.javarush.task.task26.task2613;

import com.javarush.task.task26.task2613.exception.NotEnoughMoneyException;

import java.util.*;

public class CurrencyManipulator {
    private String currencyCode;
    private Map<Integer, Integer> denominations = new HashMap<>();

    public CurrencyManipulator(String currencyCode) {
        this.currencyCode = currencyCode;
    }

    public String getCurrencyCode() {
        return currencyCode;
    }

    public void addAmount(int denomination, int count) {
        if (denominations.containsKey(denomination))
            denominations.put(denomination, denominations.get(denomination) + count);
        else denominations.put(denomination, count);
    }

    public int getTotalAmount() {
        int total = 0;
        for (Map.Entry<Integer, Integer> entry : denominations.entrySet()) {
            total += entry.getKey() * entry.getValue();
        }
        return total;
    }

    public boolean hasMoney() {
        if (getTotalAmount() == 0) return false;
        else return true;
    }

    public boolean isAmountAvailable(int expectedAmount) {
        if (expectedAmount <= getTotalAmount()) return true;
        else return false;
    }

    public Map<Integer, Integer> withdrawAmount(int expectedAmount) throws NotEnoughMoneyException {
        Map<Integer, Integer> listBanknotes = new TreeMap<>(Collections.reverseOrder());
        Map<Integer, Integer> tempDenominations = new TreeMap<>(Collections.reverseOrder());
        tempDenominations.putAll(denominations);
        //удаляем номиналы без количества
        tempDenominations.entrySet().removeIf(p -> p.getValue() == 0);

        List<Integer> nominal = new ArrayList<>(tempDenominations.keySet());
        List<Integer> count = new ArrayList<>(tempDenominations.values());
        int total = 0;

        for (int j = 0; j < nominal.size(); j++) {
            //первый цикл начинаем с банкнот максимального достоинства
            for (int i = j; i < nominal.size(); i++) {
                //если банкнота в банкомате есть
                if (count.get(i) > 0) {
                    //если номинала нет в мапе создаем
                    if (!listBanknotes.containsKey(nominal.get(i))) listBanknotes.put(nominal.get(i), 1);
                    //если номинал есть инкрементируем
                    else listBanknotes.put(nominal.get(i), listBanknotes.get(nominal.get(i)) + 1);
                    //уменьшаем количество доступных купюр
                    count.set(i, count.get(i) - 1);
                } else continue;
                //считаем сумму банкнот
                total = 0;
                for (Map.Entry<Integer, Integer> entry : listBanknotes.entrySet()) {
                    total += entry.getKey() * entry.getValue();
                }
                //если сумма равна, выдаем результат
                if (expectedAmount == total)  {
                    listBanknotes.entrySet().removeIf(p -> p.getValue() == 0);
                    //удаляем выданные банкноты из банкомата
                    for (Map.Entry<Integer, Integer> entry : listBanknotes.entrySet()) {
                        denominations.put(entry.getKey(), denominations.get(entry.getKey()) - entry.getValue());
                    }
                    return listBanknotes;
                }
                //если сумма больше, возвращаем банкноту и переходим к более мелкой купюре
                else if (expectedAmount < total) {
                    listBanknotes.put(nominal.get(i), listBanknotes.get(nominal.get(i)) - 1);
                    count.set(i, count.get(i) + 1);
                }
                //если сумма меньше, берем следующую купюру того же номинала
                else i--;
                //если банкноты номинала кончились, переходим к меньшему номиналу
            }
        }

        //если не удалось подобрать нужную комбинацию
        if (expectedAmount != total) throw new NotEnoughMoneyException();

        return null;
    }
}
