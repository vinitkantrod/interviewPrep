package com.vinit.design.concurrency.runnableWay;

public class RunnableImpl implements Runnable {
    @Override
    public void run() {
        Thread.onSpinWait();
        System.out.println(Thread.currentThread().getName());
    }
}
