package com.lanniuh.thread;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.*;

/**
 * 执行者执行返回结果的任务
 * executor使用submit()方法提交一个Callable对象给执行者执行。这个方法接收Callable对象参数，并且返回一个Future对象
 *   可以控制任务的状态：你可以取消任务，检查任务是否已经完成。
 *   可以获取call()方法返回的结果。基于这个目的，你已经使用了get()方法。这个方法会等待，直到Callable对象完成call()方法的执行，并且返回它的结果。如果线程在get()方法上等待结果时被中断，它将抛出InterruptedException异常。如果call()方法抛出 异常，这个方法会抛出ExecutionException异常。
 * Created by linjian
 * 16/8/24.
 */
public class ThreadDemo7 {
    public static void main(String[] args) {
        ThreadPoolExecutor executor = (ThreadPoolExecutor) Executors.newCachedThreadPool();
        List<Future<Integer>> resultList = new ArrayList<>();

        for (int i = 0; i < 10; i++) {
            int number = new Random().nextInt(10);
            FactorialCalculator calculator = new FactorialCalculator(number);
            Future<Integer> result = executor.submit(calculator);
            resultList.add(result);
        }

        do {
            System.out.printf("Main: Number of Completed Tasks:%d\n", executor.getCompletedTaskCount());
            for (int i = 0; i < resultList.size(); i++) {
                Future<Integer> result = resultList.get(i);
                System.out.printf("Main: Task %d: %s\n", i, result.isDone());
            }

        } while (executor.getCompletedTaskCount() < resultList.size());
        System.out.printf("Main: Results\n");
        for (int i = 0; i < resultList.size(); i++) {
            Future<Integer> result = resultList.get(i);
            Integer number = null;
            try {
                number = result.get();
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (ExecutionException e) {
                e.printStackTrace();
            }
            System.out.printf("Main: Task %d: %d\n", i, number);
        }
        executor.shutdown();
    }
}

class FactorialCalculator implements Callable<Integer> {
    private Integer number;

    public FactorialCalculator(Integer number) {
        this.number = number;
    }

    @Override
    public Integer call() throws Exception {
        int result = 1;
        if (number == 0 || number == 1) {
            result = 1;
        } else {
            for (int i = 2; i <= number; i++) {
                result *= i;
                TimeUnit.MILLISECONDS.sleep(20);
            }
        }
        System.out.printf("%s: %d\n", Thread.currentThread().getName(), result);
        return result;
    }
}
