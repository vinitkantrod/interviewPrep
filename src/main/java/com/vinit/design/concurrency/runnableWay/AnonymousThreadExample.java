package com.vinit.design.concurrency.runnableWay;

public class AnonymousThreadExample {

    public static void main(String[] args) throws InterruptedException {
        Thread t = new Thread(() -> {
            System.out.println(Thread.currentThread().getName());
            System.out.println(Thread.currentThread().getId());
            System.out.println(Thread.currentThread().getThreadGroup());
            System.out.println(Thread.currentThread().getPriority());
            System.out.println(Thread.currentThread().getState());
            System.out.println(Thread.currentThread().toString());
        });
        t.sleep(5000);
        t.start();
    }
}
