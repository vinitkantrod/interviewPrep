package com.vinit.design.concurrency.threadWay;

public class ThreadImplementation extends Thread {
    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName());
    }

    public static void main(String[] args) throws InterruptedException {
        ThreadExample tx = new ThreadExample();
        tx.start();
        ThreadExample txx = new ThreadExample();
        txx.start();
    }

    static class ThreadExample extends Thread {
        @Override
        public void run() {
            System.out.println(Thread.currentThread().getName());
        }
    }
}
