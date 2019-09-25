package com.javarush.task.task35.task3513;

import java.util.*;

public class Model {
    private static final int FIELD_WIDTH = 4;
    private Tile[][] gameTiles = new Tile[FIELD_WIDTH][FIELD_WIDTH];
    public int score = 0;
    public int maxTile = 0;
    private Stack<Tile[][]> previousStates = new Stack<>();
    private Stack<Integer> previousScores = new Stack<>();
    private boolean isSaveNeeded = true;

    public Model() {
        resetGameTiles();
    }

    public Tile[][] getGameTiles() {
        return gameTiles;
    }

    private void saveState(Tile[][] tiles) {
        Tile[][] t = new Tile[FIELD_WIDTH][FIELD_WIDTH];
        for (int i = 0; i < FIELD_WIDTH; i++) {
            for (int j = 0; j < FIELD_WIDTH; j++) {
                t[i][j] = new Tile(tiles[i][j].value);
            }
        }
        previousStates.push(t);
        Integer s = new Integer(score);
        previousScores.push(s);
        isSaveNeeded = false;
    }

    public void rollback() {
        if (!previousScores.empty() && !previousStates.empty()) {
            gameTiles = previousStates.pop();
            score = previousScores.pop();
        }
    }


    public boolean canMove() {

        if (!getEmptyTiles().isEmpty()) return true;

        for (int i = 0; i < FIELD_WIDTH; i++) {
            for (int j = 0; j < FIELD_WIDTH - 1; j++) {
                if (gameTiles[i][j].value == gameTiles[i][j + 1].value) return true;
            }
        }

        for (int i = 0; i < FIELD_WIDTH; i++) {
            for (int j = 0; j < FIELD_WIDTH - 1; j++) {
                if (gameTiles[j][i].value == gameTiles[j + 1][i].value) return true;
            }
        }

        return false;
    }

    private void addTile() {
        List<Tile> list = getEmptyTiles();
        if (!list.isEmpty()) {
            int index = (int) (list.size() * Math.random());
            list.get(index).value = (Math.random() < 0.9 ? 2 : 4);
        }
    }

    public void left() {
        if (isSaveNeeded) saveState(gameTiles);

        boolean hasChanged = false;
        for (int i = 0; i < FIELD_WIDTH; i++) {
            if (compressTiles(gameTiles[i])) {
                hasChanged = true;
            }
            if (mergeTiles(gameTiles[i])) {
                hasChanged = true;
            }
        }
        if (hasChanged) addTile();

        isSaveNeeded = true;
    }

    public void up() {
        saveState(gameTiles);
        rotate90();
        rotate90();
        rotate90();
        left();
        rotate90();
    }

    public void right() {
        saveState(gameTiles);
        rotate90();
        rotate90();
        left();
        rotate90();
        rotate90();
    }

    public void down() {
        saveState(gameTiles);
        rotate90();
        left();
        rotate90();
        rotate90();
        rotate90();
    }

    private void rotate90() {//крутим по часовой стрелке
        Tile[][] tiles = new Tile[FIELD_WIDTH][FIELD_WIDTH];

        for (int i = 0; i < FIELD_WIDTH; i++) {//крутим по часовой стрелке
            for (int j = 0; j < FIELD_WIDTH; j++) {
                tiles[j][FIELD_WIDTH - i - 1] = gameTiles[i][j];
            }
        }
        gameTiles = tiles;
    }

    private List<Tile> getEmptyTiles() {
        List<Tile> list = new ArrayList<>();
        for (int i = 0; i < FIELD_WIDTH; i++) {
            for (int j = 0; j < FIELD_WIDTH; j++) {
                if (gameTiles[i][j].isEmpty()) list.add(gameTiles[i][j]);
            }
        }
        return list;
    }

    public void resetGameTiles() {
        for (int i = 0; i < FIELD_WIDTH; i++) {
            for (int j = 0; j < FIELD_WIDTH; j++) {
                gameTiles[i][j] = new Tile();
            }
        }
        addTile();
        addTile();
        maxTile = 0;
        score = 0;
    }

    private boolean compressTiles(Tile[] tiles) {
        boolean haveEmpty = false;
        boolean hasChanged = false;
        for (int i = 0; i < FIELD_WIDTH; i++) {
            if (tiles[i].isEmpty()) haveEmpty = true;
            if (haveEmpty && tiles[i].value > 0) {
                hasChanged = true;
            }
        }
        if (hasChanged) {
            for (int j = 0; j < FIELD_WIDTH - 1; j++) {
                for (int i = 0; i < FIELD_WIDTH - 1; i++) {
                    if (tiles[i].isEmpty()) {
                        tiles[i].value = tiles[i + 1].value;
                        tiles[i + 1].value = 0;
                    }
                }
            }
        }
        return hasChanged;
    }

    private boolean mergeTiles(Tile[] tiles) {
        boolean hasChanged = false;
        int first = 0, second = 0;
        first = tiles[0].value;
        for (int i = 1; i < FIELD_WIDTH; i++) {
            second = tiles[i].value;

            if (first == second && first > 0) { // если два тайла равны и больше 0
                int newValue = tiles[i].value * 2;
                tiles[i - 1].value = newValue;
                tiles[i].value = 0;
                score += newValue;
                if (maxTile < newValue) maxTile = newValue;
                compressTiles(tiles);
                first = tiles[i].value;
                hasChanged = true;
            } else if (first > 0) { // если два тайла не равны
                first = second;
            }
        }
        return hasChanged;
    }

    public void randomMove() {
        int n = ((int) (Math.random() * 100)) % 4;
        if (n == 0) left();
        else if (n == 1) right();
        else if (n == 2) up();
        else down();
    }

    public boolean hasBoardChanged() {
        int sumGame = 0;
        int sumStack = 0;
        Tile[][] stack = previousStates.peek();
        for (int i = 0; i < FIELD_WIDTH; i++) {
            for (int j = 0; j < FIELD_WIDTH; j++) {
                sumGame += gameTiles[i][j].value;
                sumStack += stack[i][j].value;
            }
        }
        return (sumGame == sumStack) ? false : true;
    }

    public MoveEfficiency getMoveEfficiency(Move move) {
        move.move();
        MoveEfficiency moveEfficiency;
        if (!hasBoardChanged()) moveEfficiency = new MoveEfficiency(-1, 0, move);
        else moveEfficiency = new MoveEfficiency(getEmptyTiles().size(), score, move);
        rollback();
        return moveEfficiency;
    }

    public void autoMove() {
        PriorityQueue<MoveEfficiency> queue = new PriorityQueue(4, Collections.reverseOrder());
        queue.offer(getMoveEfficiency(this::left));
        queue.offer(getMoveEfficiency(this::right));
        queue.offer(getMoveEfficiency(this::down));
        queue.offer(getMoveEfficiency(this::up));
        MoveEfficiency me = queue.poll();
        me.getMove().move();

    }
}