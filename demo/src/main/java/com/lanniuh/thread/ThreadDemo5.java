package com.lanniuh.thread;

/**
 * 线程的中断。中断机制的特性是线程需要检查是否被中断，而且还可以决定是否响应结束的请求。所以，线程可以忽略中断请求并且继续运行。
 * Created by linjian
 * 16/8/24.
 */
public class ThreadDemo5 implements Runnable {
    private int number;

    @Override
    public void run() {
        while (true) {
            if (Thread.currentThread().isInterrupted()) {
                System.out.println("Thread is interrupted!");
                break;
            } else {
                System.out.println(number);
            }
            number++;
        }
    }


    public static void main(String[] args) {
        ThreadDemo5 demo5 = new ThreadDemo5();
        Thread thread = new Thread(demo5);
        thread.start();
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        thread.interrupt();
    }
}
