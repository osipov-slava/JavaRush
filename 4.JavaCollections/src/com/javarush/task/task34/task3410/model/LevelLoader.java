package com.javarush.task.task34.task3410.model;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.file.Path;
import java.util.HashSet;
import java.util.Set;

import static com.javarush.task.task34.task3410.model.Model.FIELD_CELL_SIZE;

public class LevelLoader {
    private BufferedReader readerFile = null;
    private Path levels;

    public LevelLoader(Path levels) {
        this.levels = levels;
    }

    public GameObjects getLevel(int level) {
        level = level % 60;
        if (level == 0) level = 60;
        Set<Home> homes = new HashSet<>();
        Set<Box> boxes = new HashSet<>();
        Set<Wall> walls = new HashSet<>();
        Player player = null;

        try {
            readerFile = new BufferedReader(new InputStreamReader(new FileInputStream(levels.toFile())));

            String strLine;
            while ((strLine = readerFile.readLine()) != null) {
                if (!strLine.matches("Maze: " + level)) continue;
                for (int i = 0; i < 6; i++) readerFile.readLine();
                int y = FIELD_CELL_SIZE / 2;
                while (!(strLine = readerFile.readLine()).equals("")) {
                    char[] chars = strLine.toCharArray();
                    for (int i = 0; i < chars.length; i++) {
                        int x = FIELD_CELL_SIZE / 2 + i * FIELD_CELL_SIZE;
                        switch (chars[i]) {
                            case 'X': {
                                walls.add(new Wall(x, y));
                                break;
                            }
                            case '*': {
                                boxes.add(new Box(x, y));
                                break;
                            }
                            case '.': {
                                homes.add(new Home(x, y));
                                break;
                            }
                            case '&': {
                                boxes.add(new Box(x, y));
                                homes.add(new Home(x, y));
                                break;
                            }
                            case '@': {
                                player = new Player(x, y);
                                break;
                            }
                        }
                    }
                    y += FIELD_CELL_SIZE;
                }
            }
            readerFile.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return new GameObjects(walls, boxes, homes, player);
    }
}
