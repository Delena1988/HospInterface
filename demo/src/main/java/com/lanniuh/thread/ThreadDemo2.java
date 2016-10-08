package com.lanniuh.thread;

/**
 * 然而，当一个线程访问object的一个synchronized(this)同步代码块时，另一个线程仍然可以访问该object中的非synchronized(this)同步代码块。
 * Created by linjian
 * 16/8/23.
 */
public class ThreadDemo2 {
    public void m4t1() {
        synchronized (this) {
            int i = 5;
            while (i-- > 0) {
                System.out.println(Thread.currentThread().getName() + " : " + i);
                try {
                    Thread.sleep(500);
                } catch (InterruptedException ie) {
                }
            }
        }
    }

    public void m4t2() {
        int i = 5;
        while (i-- > 0) {
            System.out.println(Thread.currentThread().getName() + " : " + i);
            try {
                Thread.sleep(500);
            } catch (InterruptedException ie) {
            }
        }
    }

    public static void main(String[] args) {
        final ThreadDemo2 myt2 = new ThreadDemo2();
        Thread t1 = new Thread(new Runnable() {
            public void run() {
                myt2.m4t1();
            }
        }, "t1");
        Thread t2 = new Thread(new Runnable() {
            public void run() {
                myt2.m4t2();
            }
        }, "t2");
        t1.start();
        t2.start();
    }
}
