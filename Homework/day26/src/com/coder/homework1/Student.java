package com.coder.homework1;

import java.util.concurrent.TimeUnit;

public class Student implements Runnable {
    @Override
    public void run() {
        System.out.println("学生打算先睡5秒");
        try {
            TimeUnit.SECONDS.sleep(5);
        } catch (InterruptedException e) {
            System.out.println("学生被老师吵醒");
        }
        System.out.println("上课");
    }
}
