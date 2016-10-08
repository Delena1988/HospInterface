package com.lanniuh.thread;

/**
 * 可重入锁，也叫做递归锁，指的是同一线程 外层函数获得锁之后 ，内层递归函数仍然有获取该锁的代码，但不受影响。
 * 可重入锁最大的作用是避免死锁。
 * Created by linjian
 * 16/8/23.
 */
public class ThreadDemo4 implements Runnable {
    public synchronized void get() {
        System.out.println(Thread.currentThread().getId());
        set();
    }

    public synchronized void set() {
        System.out.println(Thread.currentThread().getId());
    }

    public static void main(String[] args) {
        ThreadDemo4 demo4=new ThreadDemo4();
        new Thread(demo4).start();
        new Thread(demo4).start();
        new Thread(demo4).start();
    }

    @Override
    public void run() {
        get();
    }
}
