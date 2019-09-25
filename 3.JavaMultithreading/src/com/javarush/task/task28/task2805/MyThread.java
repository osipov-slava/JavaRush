package com.javarush.task.task28.task2805;

public class MyThread extends Thread {
    private static int priority = 1;

    private int getPrior() {
        if (priority == 11) priority = 1;
        return priority++;
    }

    public MyThread() {
        if (getThreadGroup() != null) {
            int newPrior = getPrior();
            if (newPrior > getThreadGroup().getMaxPriority())
                setPriority(getThreadGroup().getMaxPriority());
            else setPriority(newPrior);
        } else setPriority(getPrior());
    }

    public MyThread(Runnable target) {
        super(target);
        if (getThreadGroup() != null) {
            int newPrior = getPrior();
            if (newPrior > getThreadGroup().getMaxPriority())
                setPriority(getThreadGroup().getMaxPriority());
            else setPriority(newPrior);
        } else setPriority(getPrior());
    }

    public MyThread(ThreadGroup group, Runnable target) {
        super(group, target);
        if (getThreadGroup() != null) {
            int newPrior = getPrior();
            if (newPrior > getThreadGroup().getMaxPriority())
                setPriority(getThreadGroup().getMaxPriority());
            else setPriority(newPrior);
        } else setPriority(getPrior());
    }

    public MyThread(String name) {
        super(name);
        if (getThreadGroup() != null) {
            int newPrior = getPrior();
            if (newPrior > getThreadGroup().getMaxPriority())
                setPriority(getThreadGroup().getMaxPriority());
            else setPriority(newPrior);
        } else setPriority(getPrior());
    }

    public MyThread(ThreadGroup group, String name) {
        super(group, name);
        if (getThreadGroup() != null) {
            int newPrior = getPrior();
            if (newPrior > getThreadGroup().getMaxPriority())
                setPriority(getThreadGroup().getMaxPriority());
            else setPriority(newPrior);
        } else setPriority(getPrior());
    }

    public MyThread(Runnable target, String name) {
        super(target, name);
        if (getThreadGroup() != null) {
            int newPrior = getPrior();
            if (newPrior > getThreadGroup().getMaxPriority())
                setPriority(getThreadGroup().getMaxPriority());
            else setPriority(newPrior);
        } else setPriority(getPrior());
    }

    public MyThread(ThreadGroup group, Runnable target, String name) {
        super(group, target, name);
        if (getThreadGroup() != null) {
            int newPrior = getPrior();
            if (newPrior > getThreadGroup().getMaxPriority())
                setPriority(getThreadGroup().getMaxPriority());
            else setPriority(newPrior);
        } else setPriority(getPrior());
    }

    public MyThread(ThreadGroup group, Runnable target, String name, long stackSize) {
        super(group, target, name, stackSize);
        if (getThreadGroup() != null) {
            int newPrior = getPrior();
            if (newPrior > getThreadGroup().getMaxPriority())
                setPriority(getThreadGroup().getMaxPriority());
            else setPriority(newPrior);
        } else setPriority(getPrior());
    }

}