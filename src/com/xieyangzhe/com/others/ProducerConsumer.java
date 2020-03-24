package com.xieyangzhe.com.others;

import java.util.concurrent.Semaphore;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author Yangzhe Xie
 * @date 20/12/19
 */
public class ProducerConsumer {

    private static AtomicInteger count = new AtomicInteger(0);
    private static final Integer MAX = 10;
    private static Lock lock = new ReentrantLock();
    private static final Condition full = lock.newCondition();
    private static final Condition empty = lock.newCondition();

    public static void main(String[] args) {
        new Thread(new Producer()).start();
        new Thread(new Producer()).start();
        new Thread(new Producer()).start();
        new Thread(new Producer()).start();
        new Thread(new Producer()).start();
        new Thread(new Consumer()).start();
        new Thread(new Consumer()).start();
        new Thread(new Consumer()).start();
        new Thread(new Consumer()).start();
        new Thread(new Consumer()).start();
        new Thread(new Consumer()).start();
        new Thread(new Consumer()).start();
        new Thread(new Consumer()).start();
    }

    public static class Producer implements Runnable {
        @Override
        public void run() {
            for (int i = 0; i < 10; i++) {
                try {
                    Thread.sleep(3000);
                } catch (Exception e) {
                    e.printStackTrace();
                }
                lock.lock();
                try {
                    while (count.get() == MAX) {
                        try {
                            full.await();
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                    count.incrementAndGet();
                    System.out.println(Thread.currentThread().getName()
                            + " produce - " + count);
                    empty.signalAll();
                } finally {
                    lock.unlock();
                }
            }
        }
    }

    public static class Consumer implements Runnable {
        @Override
        public void run() {
            for (int i = 0; i < 10; i++) {
                try {
                    Thread.sleep(3000);
                } catch (Exception e) {
                    e.printStackTrace();
                }
                lock.lock();
                try {
                    while (count.get() == 0) {
                        try {
                            empty.await();
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                    count.decrementAndGet();
                    System.out.println(Thread.currentThread().getName()
                            + " consume - " + count);
                    full.signalAll();
                } finally {
                    lock.unlock();
                }
            }
        }
    }
}
