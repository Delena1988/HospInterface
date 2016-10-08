package com.lanniuh.singleton;

/**
 * 懒汉式,线程安全,但是并不高效
 * Created by linjian
 * 16/8/22.
 */
public class SingletonDemo2 {
    private static SingletonDemo2 instance;

    private SingletonDemo2() {
    }

    public static synchronized SingletonDemo2 getInstance() {
        if (instance == null) {
            return new SingletonDemo2();
        }
        return instance;
    }
}
