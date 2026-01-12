package com.coder.homework2;

import java.util.concurrent.TimeUnit;

public class Cave{
    public synchronized void pass() {
        System.out.println(Thread.currentThread().getName() + "进入山洞");
        try {
            TimeUnit.SECONDS.sleep(5);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName() + "通过山洞");
    }
}
