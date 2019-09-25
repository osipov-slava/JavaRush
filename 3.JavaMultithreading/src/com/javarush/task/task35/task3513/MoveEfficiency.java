package com.javarush.task.task35.task3513;

public class MoveEfficiency implements Comparable<MoveEfficiency> {
    private int numberOfEmptyTiles;
    private int score;
    private Move move;

    public MoveEfficiency(int numberOfEmptyTiles, int score, Move move) {
        this.numberOfEmptyTiles = numberOfEmptyTiles;
        this.score = score;
        this.move = move;
    }

    public Move getMove() {
        return move;
    }

    @Override
    public int compareTo(MoveEfficiency o) {

        if (Integer.compare(numberOfEmptyTiles, o.numberOfEmptyTiles) != 0)
            return Integer.compare(numberOfEmptyTiles, o.numberOfEmptyTiles);
        if (Integer.compare(score, o.score) != 0) 
            return Integer.compare(score, o.score);
        return 0;

    }
}
