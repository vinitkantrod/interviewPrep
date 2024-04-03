package com.vinit.design.concurrency.runnableWay;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ExecutorServiceExample {
    public static void main(String[] args) {
        ExecutorService executor = Executors.newFixedThreadPool(2);
        for (int i = 0; i < 20; ++i) {
            int finalI = i;
            executor.submit(() -> {
                System.out.println("task " + finalI + " running on thread " + Thread.currentThread().getName());
            });
        }
        executor.shutdown();
    }
}
