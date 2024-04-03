package com.vinit.design.concurrency.runnableWay;

import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * Race condition can occure when multiple threads are trying to read
 * same value and simultaneosly other thread is updating that value.
 * Reac can be incosistent in this.
 * To solve this we use synchronised method to avoid such issue
 * In java, we can use Lock so that anyone before writing or reading will
 * accquire lock and then read/write the value so that all the threads
 * sees a consistent result
 */
public class RaceConditionExamples {
    public static void main(String[] args) {
        SimpleIncrement ic = new SimpleIncrement();
        IncrementWithReentrantLock rc = new IncrementWithReentrantLock();
        IncrementReentrantReadWriteLock rw = new IncrementReentrantReadWriteLock();
        IncrementSynchronized s = new IncrementSynchronized();
        for (int i = 0; i < 1000; ++i) {
            final  int finalI = i;
            Thread t = new Thread(() -> {
                ic.increment();
                rc.increment();
                rw.increment();
                s.increment();
            });
            t.start();
        }
        System.out.println(ic.getCount());
        System.out.println(rw.getCount());
        System.out.println(rc.getCount());
        // synchronized
        System.out.println(s.getCount());
        // Deadlock
        deadlockExample();

    }
    // Class Without lock handling
    public static class SimpleIncrement {
        private int count;
        public SimpleIncrement() {
            this.count = 0;
        }
        public void increment() {
            this.count += 1;
        }
        public int getCount() {return this.count;}
    }

    // Class Without lock handling
    public static class IncrementWithReentrantLock {
        private int count;
        public final ReentrantLock lock = new ReentrantLock();
        public IncrementWithReentrantLock() {
            this.count = 0;
        }
        public void increment() {
            lock.lock();
            try {
                this.count += 1;
            } finally {
                lock.unlock();
            }
        }
        public int getCount() {return this.count;}
    }

    /**
     * ReentrantReadWriteLock - in this multiple threads can read if no write
     * lock is accquired
     * Write lock will only be accquired is both read and write lock is free
     *
     */
    public static class IncrementReentrantReadWriteLock {
        private int count;
        public final ReentrantReadWriteLock lock = new ReentrantReadWriteLock();

        public IncrementReentrantReadWriteLock() {
            this.count = 0;
        }
        public int getCount() {
            lock.readLock().lock();
            try {
                return this.count;
            } finally {
                lock.readLock().unlock();
            }
        }
        public void increment() {
            lock.writeLock().lock();
            try {
                this.count++;
            } finally {
                lock.writeLock().unlock();
            }
        }
    }
    public static class IncrementSynchronized {
        private int count;
        public IncrementSynchronized() {
            this.count = 0;
        }
        public synchronized void increment() {
                this.count += 1;
        }
        public int getCount() {return this.count;}
    }

    /**
     * Deadlock:
     */
    public static void deadlockExample() {
        ReentrantLock r1 = new ReentrantLock();
        ReentrantLock r2 = new ReentrantLock();
        Thread t1 = new Thread(() -> {
            r1.lock();
            try {
                System.out.println("T1 has accquired lock A");
                r2.lock();
                try {
                    System.out.println("T1 has accquired lock B");
                } finally {
                    r2.unlock();
                }
            } finally {
                r1.unlock();
            }
        });
        Thread t2 = new Thread(() -> {
            r2.lock();
            try {
                System.out.println("T2 has accquired lock B");
                r1.lock();
                try {
                    System.out.println("T2 has accquired lock A");
                } finally {
                    r1.unlock();
                }
            } finally {
                r2.unlock();
            }
        });
        t1.start();
        t2.start();
    }
}
