package com.lanniuh.singleton;

/**
 * 懒汉式,线程不安全
 * Created by linjian
 * 16/8/22.
 */
public class SingletonDemo {
    private static SingletonDemo instance;

    private SingletonDemo() {
    }

    public static SingletonDemo getInstance() {
        if (instance == null) {
            return new SingletonDemo();
        }
        return instance;
    }

}
