package com.xieyangzhe.others;

/**
 * @author Yangzhe Xie
 * @date 21/6/20
 */
public class Singleton {
    private static volatile Singleton instance;

    private Singleton() {
    }

    public static Singleton getInstance() {
        if (instance == null) {
            synchronized (Singleton.class) {
                if (instance == null) {
                    instance = new Singleton();
                }
            }
        }
        return instance;
    }

    private static class SingletonNew {
        private SingletonNew() {
        }

        public static SingletonNew getInstance() {
            return InstanceHolder.INSTANCE;
        }

        private static class InstanceHolder {
            public static SingletonNew INSTANCE = new SingletonNew();
        }
    }
}
