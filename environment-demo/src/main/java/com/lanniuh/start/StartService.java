package com.lanniuh.start;

import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by linjian
 * 16/8/31.
 */
public class StartService {
    public static ClassPathXmlApplicationContext context;

    public static void main(String[] args) {
        context = new ClassPathXmlApplicationContext("classpath:spring/spring-context.xml");
        context.start();
        while (true) {
            try {
                Thread.sleep(300000);
            } catch (InterruptedException e) {
            }
        }
    }
}
