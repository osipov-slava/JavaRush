package com.javarush.task.task34.task3410.model;

import java.awt.*;

public class Home extends GameObject {
    public Home(int x, int y) {
        super(x, y);
        setHeight(2);
        setWidth(2);
    }


    @Override
    public void draw(Graphics graphics) {
        graphics.setColor(Color.red);
        graphics.drawOval(getX() + Model.FIELD_CELL_SIZE / 2,
                getY() + Model.FIELD_CELL_SIZE / 2,
                getWidth(),
                getHeight());
    }
}
