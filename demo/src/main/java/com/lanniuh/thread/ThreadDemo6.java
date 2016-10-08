package com.lanniuh.thread;

import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

/**
 * 创建线程执行者ThreadPoolExecutor
 * Created by linjian
 * 16/8/24.
 */

/**
 * Executors
 * public static ExecutorService newCachedThreadPool()
 *   Creates a thread pool that creates new threads as needed, but will reuse previously constructed threads when they are available.
 * public static ExecutorService newFixedThreadPool(int nThreads)
 *   Creates a thread pool that reuses a fixed number of threads operating off a shared unbounded queue.
 */
public class ThreadDemo6 {
    public static void main(String[] args) {
        ThreadPoolExecutor executor = (ThreadPoolExecutor) Executors.newCachedThreadPool();
        for (int i = 0; i < 2000; i++) {
            Task task = new ThreadDemo6().new Task();
            executor.execute(task);
        }
        System.out.println("ActiveCount: "+executor.getActiveCount());
        System.out.println("CompletedTaskCount: "+executor.getCompletedTaskCount());
        System.out.println("CorePoolSize: "+executor.getCorePoolSize());
        System.out.println("LargestPoolSize: "+executor.getLargestPoolSize());
        System.out.println("MaximumPoolSize: "+executor.getMaximumPoolSize());
        executor.shutdown();
    }
    class Task implements Runnable {
        @Override
        public void run() {
            System.out.println(Thread.currentThread().getName() + " is running!");
        }
    }
}

