package com.lanniuh.singleton;

/**
 * 静态内部类 static nested class 《Effective Java》推荐的
 * Created by linjian
 * 16/8/22.
 */
public class SingletonDemo5 {
    private static class SingletonHolder {
        private static final SingletonDemo5 INSTANCE = new SingletonDemo5();
    }

    private SingletonDemo5() {
    }

    public static final SingletonDemo5 getInstance() {
        return SingletonHolder.INSTANCE;
    }
}
