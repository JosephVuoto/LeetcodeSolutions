package com.xieyangzhe.others.designpattern;

/**
 * @author Yangzhe Xie
 * @date 5/7/20
 */
public class Singleton1 {
    private Singleton1() {
    }

    public static Singleton1 getInstance() {
        return Holder.instance;
    }

    private static class Holder {
        private static final Singleton1 instance = new Singleton1();
    }
}
