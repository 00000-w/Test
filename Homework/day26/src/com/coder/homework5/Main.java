package com.coder.homework5;

import java.util.concurrent.TimeUnit;

public class Main {
    final static Object LOCK = new Object();
    static int message = 0;
    public static void main(String[] args) {
            Thread produceThread1 = new Thread(() -> produce());
            Thread produceThread2 = new Thread(() -> produce());
            Thread produceThread3 = new Thread(() -> produce());

            Thread readThread = new Thread(() -> {
                while (true) {
                    synchronized (LOCK) {
                        while (message > 0) {
                            System.out.println("读取一条消息");
                            message -= 1;
                            LOCK.notifyAll();
                            try {
                                TimeUnit.SECONDS.sleep(1);
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                        }
                        System.out.println("无未读消息,等待消息");
                        try {
                            LOCK.wait();
                            LOCK.notifyAll();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    try {
                        TimeUnit.SECONDS.sleep(1);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            });

            produceThread1.start();
            produceThread2.start();
            produceThread3.start();
            readThread.start();
    }
    public static void produce() {
        while (true) {
            synchronized (LOCK) {
                if (message < 2) {
                    System.out.println("生产一条消息");
                    message += 1;
                    LOCK.notifyAll();
                } else {
                    try {
                        LOCK.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
