package com.vinit.design.concurrency.runnableWay;

public class RunnableExample {
    public static void main(String[] args) {
        RunnableImpl ri = new RunnableImpl();
        Thread t = new Thread(ri);
        t.start();
    }
}
