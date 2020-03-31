package com.xieyangzhe.com.others;

import java.util.LinkedList;
import java.util.Queue;
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
    private static Lock lock = new ReentrantLock();
    private static Condition notFull = lock.newCondition();
    private static Condition notEmpty = lock.newCondition();

    private static final int MAX_CAPACITY = 10;
    private static AtomicInteger nextId = new AtomicInteger(1);
    private static Queue<Integer> queue = new LinkedList<>();

    public static void main(String[] args) {
        for (int i = 1; i < 6; i++) {
            new Thread(new Producer(), "producer" + i).start();
        }
        for (int i = 1; i < 6; i++) {
            new Thread(new Consumer(), "consumer" + i).start();
        }
    }

    private static class Producer implements Runnable {
        @Override
        public void run() {
            while (true) {
                lock.lock();
                try {
                    while (queue.size() == MAX_CAPACITY) {
                        notFull.await();
                    }
                    int k = nextId.getAndIncrement();
                    System.out.println(Thread.currentThread().getName() + " - " + k);
                    queue.add(k);
                    notEmpty.signal();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    lock.unlock();
                }
                try {
                    Thread.sleep(3000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    private static class Consumer implements Runnable {
        @Override
        public void run() {
            while (true) {
                lock.lock();
                try {
                    while (queue.isEmpty()) {
                        notEmpty.await();
                    }
                    int k = queue.poll();
                    System.out.println(Thread.currentThread().getName() + " - " + k);
                    notFull.signal();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    lock.unlock();
                }
                try {
                    Thread.sleep(3000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
