package com.javarush.task.task27.task2712.statistic.event;

import java.util.Date;

import static com.javarush.task.task27.task2712.statistic.event.EventType.NO_AVAILABLE_VIDEO;

public class NoAvailableVideoEventDataRow implements EventDataRow{
    private int totalDuration;// - время приготовления заказа в секундах
    Date currentDate;

    public NoAvailableVideoEventDataRow(int totalDuration) {
        this.totalDuration = totalDuration;
        currentDate = new Date();
    }

    @Override
    public EventType getType() {
        return NO_AVAILABLE_VIDEO;
    }

    @Override
    public Date getDate() {
        return currentDate;
    }

    @Override
    public int getTime() {
        return totalDuration;
    }
}
