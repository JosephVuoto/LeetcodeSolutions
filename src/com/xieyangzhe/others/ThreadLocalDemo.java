package com.xieyangzhe.others;

import java.util.Random;

/**
 * @author Yangzhe Xie
 * @date 28/3/20
 */
public class ThreadLocalDemo {
    ThreadLocal<Integer> threadLocal = new ThreadLocal<>();

    public static void main(String[] args) {
        ThreadLocalDemo demo = new ThreadLocalDemo();
        for (int i = 0; i < 10; i++) {
            int finalI = i;
            new Thread(() -> {
                demo.threadLocal.set(finalI);
                try {
                    Thread.sleep(new Random().nextInt(10) * 100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(finalI + " " + demo.threadLocal.get());
            }).start();
        }
    }
}
