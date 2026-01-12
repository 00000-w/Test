package com.coder.homework2;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class Main {
    static final ReentrantLock LOCK = new ReentrantLock();
    static int number = 0;
    static Condition aCondition = LOCK.newCondition();
    static Condition bCondition = LOCK.newCondition();
    static Condition cCondition = LOCK.newCondition();
    public static void main(String[] args) {
        for (int i = 0; i < 3; i++) {
            Thread t1 = new Thread(() -> {
                try {
                    LOCK.lock();
                    while (number != 0)
                        aCondition.await();
                    System.out.println("购买商品下单");
                    number = 1;
                    bCondition.signal();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    LOCK.unlock();
                }
            });

            Thread t2 = new Thread(() -> {
                try {
                    LOCK.lock();
                    while (number != 1)
                        bCondition.await();
                    System.out.println("使用微信付款");
                    number = 2;
                    cCondition.signal();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    LOCK.unlock();
                }
            });

            Thread t3 = new Thread(() -> {
                try {
                    LOCK.lock();
                    while (number != 2)
                        cCondition.await();
                    System.out.println("个人账户积分");
                    number = 0;
                    aCondition.signal();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    LOCK.unlock();
                }
            });
            t1.start();
            t2.start();
            t3.start();
        }
    }
}
