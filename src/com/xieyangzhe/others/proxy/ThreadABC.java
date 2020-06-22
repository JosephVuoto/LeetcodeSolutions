package com.xieyangzhe.others.proxy;

import sun.tools.jconsole.Worker;

/**
 * @author Yangzhe Xie
 * @date 21/6/20
 */
public class ThreadABC {
    private static volatile int nextExpected = 1;
    private static final Object lock = new Object();

    private static class Worker implements Runnable {
        private int num;

        public Worker(int num) {
            this.num = num;
        }

        @Override
        public void run() {
            synchronized (lock) {
                for (int i = 0; i < 10; i++) {
                    while (nextExpected != num) {
                        try {
                            lock.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    System.out.println((char)('A' + num - 1));
                    nextExpected = nextExpected % 3 + 1;
                    lock.notifyAll();
                }
            }
        }
    }

    public static void main(String[] args) {
        new Thread(new Worker(1)).start();
        new Thread(new Worker(2)).start();
        new Thread(new Worker(3)).start();
    }
}
