package com.javarush.task.task34.task3410.model;

import com.javarush.task.task34.task3410.controller.EventListener;

import java.io.File;

public class Model {
    private EventListener eventListener;
    private GameObjects gameObjects;
    private int currentLevel = 1;
    private LevelLoader levelLoader = new LevelLoader(new File(getClass().getResource("../res/levels.txt").getFile()).toPath());

    public static final int FIELD_CELL_SIZE = 20;

    public void setEventListener(EventListener eventListener) {
        this.eventListener = eventListener;
    }

    public GameObjects getGameObjects() {
        return gameObjects;
    }

    public void restartLevel(int level) {
        gameObjects = levelLoader.getLevel(level);
    }

    public void restart() {
        restartLevel(currentLevel);
    }

    public void startNextLevel() {
        restartLevel(++currentLevel);
    }

    public void move(Direction direction) {
        if (checkWallCollision(gameObjects.getPlayer(), direction)) return;
        if (checkBoxCollisionAndMoveIfAvaliable(direction)) return;
        switch (direction) {
            case RIGHT: {
                gameObjects.getPlayer().move(FIELD_CELL_SIZE, 0);
                break;
            }
            case LEFT: {
                gameObjects.getPlayer().move(-FIELD_CELL_SIZE, 0);
                break;
            }
            case UP: {
                gameObjects.getPlayer().move(0, -FIELD_CELL_SIZE);
                break;
            }
            case DOWN: {
                gameObjects.getPlayer().move(0, FIELD_CELL_SIZE);
                break;
            }
        }
        checkCompletion();
    }

    public boolean checkWallCollision(CollisionObject gameObject, Direction direction) {
        for (Wall wall : gameObjects.getWalls()) {
            if (gameObject.isCollision(wall, direction)) return true;
        }
        return false;
    }

    public boolean checkBoxCollisionAndMoveIfAvaliable(Direction direction) {
//        Вернуть false, если игрок может быть сдвинут в направлении direction
//                (там находится: или свободная ячейка; или дом; или ящик, за которым свободная
//        ячейка или дом). При этом, если на пути есть ящик, который может быть сдвинут,
//                то необходимо переместить этот ящик на новые координаты.
        Player p = gameObjects.getPlayer();

        for (Box box1 : gameObjects.getBoxes()) {
            if (p.isCollision(box1, direction)) {
                for (Box box2 : gameObjects.getBoxes()) {
                    if (box1.isCollision(box2, direction) && box1 != box2) return true;
                }
                if (checkWallCollision(box1, direction)) return true;

                switch (direction) {
                    case RIGHT: {
                        box1.move(FIELD_CELL_SIZE, 0);
                        break;
                    }
                    case LEFT: {
                        box1.move(-FIELD_CELL_SIZE, 0);
                        break;
                    }
                    case UP: {
                        box1.move(0, -FIELD_CELL_SIZE);
                        break;
                    }
                    case DOWN: {
                        box1.move(0, FIELD_CELL_SIZE);
                        break;
                    }
                }
            }
        }

        return false;
    }

    public void checkCompletion() {
        for (Box box : gameObjects.getBoxes()) {
            boolean boxInHome = false;
            for (Home home : gameObjects.getHomes()) {
                if (box.getX() == home.getX() && box.getY() == home.getY()) boxInHome = true;
            }
            if (!boxInHome) return;
        }
        eventListener.levelCompleted(currentLevel);
    }

}
