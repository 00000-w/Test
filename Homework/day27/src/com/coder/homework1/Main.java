package com.coder.homework1;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class Main {
    static final ReentrantLock LOCK = new ReentrantLock();
    static boolean b = false;
    static Condition bCondition = LOCK.newCondition();
    public static void main(String[] args) {
        Thread t1 = new Thread(() -> {
            try {
                LOCK.lock();
                System.out.println("生产小兵");
                b = true;
                bCondition.signal();
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                LOCK.unlock();
            }
        });

        Thread t2 = new Thread(() -> {
            try {
                LOCK.lock();
                while (!b) {
                    try {
                        System.out.println("小兵未生产...");
                        bCondition.await();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                System.out.println("攻击防御塔");
            } finally {
                LOCK.unlock();
            }
        });
        t1.start();
        t2.start();
    }
}
