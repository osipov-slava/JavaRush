package com.javarush.task.task21.task2113;

import java.util.ArrayList;
import java.util.List;

public class Hippodrome {
    private List<Horse> horses = new ArrayList<>();

    public static Hippodrome game;

    public Hippodrome() {
    }

    public Hippodrome(List<Horse> horses) {
        this.horses = horses;
    }

    public List<Horse> getHorses() {
        return horses;
    }

    public static void main(String[] args) throws Exception{

        game = new Hippodrome();
        game.horses.add(new Horse("Vaska", 3.0 , 0.0));
        game.horses.add(new Horse("Pegas", 3.0 , 0.0));
        game.horses.add(new Horse("Logovaz", 3.0 , 0.0));

        game.run();
        game.printWinner();

    }

    public void run() throws Exception{
        for (int i = 1; i <= 100 ; i++) {
            move();
            print();
            Thread.sleep(200);
        }
    }

    public void move(){
        for (Horse horse: horses) {
            horse.move();
        }
    }
    
    public void print(){
        for (Horse horse: horses) {
            horse.print();
        }
        for (int i = 0; i < 10; i++) {
            System.out.println();
        }
    }

    public Horse getWinner(){
        double max = 0.0;
        int winner = 0;
        for (int i = 0; i < horses.size(); i++) {
            if (horses.get(i).getDistance() > max) {
                max = horses.get(i).getDistance();
                winner = i;
            }
        }
        return horses.get(winner);
    }

    public void printWinner(){
        System.out.println("Winner is " + getWinner().getName() + "!");
    }

}
