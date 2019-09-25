package com.javarush.task.task25.task2506;

public class LoggingStateThread extends Thread {
    private Thread target;
    private State currentState;

    public LoggingStateThread(Thread target) {
        this.target = target;
        currentState = target.getState();
        System.out.println(currentState);
    }

    @Override
    public void run() {
        do {
            if (currentState != target.getState()) {
                currentState = target.getState();
                System.out.println(currentState);

            }
        } while (currentState != State.TERMINATED);

    }
}
