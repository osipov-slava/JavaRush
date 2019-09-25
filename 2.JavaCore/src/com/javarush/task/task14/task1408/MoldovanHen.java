package com.javarush.task.task14.task1408;

public class MoldovanHen extends Hen {
    static int countOfEggs = 0;

    int getCountOfEggsPerMonth(){
        return countOfEggs;
    }
    String getDescription(){
        return (super.getDescription() + " Моя страна - " + Country.MOLDOVA + ". Я несу " + countOfEggs + " яиц в месяц.");
    }
}
