package com.coder.homework;

public class Main {
    final static Object LOCK = new Object();
    static boolean haveMinion = false;
    static boolean haveMove = false;
    static volatile int times = 0;
    static boolean continueloop = true;
    public static void main(String[] args) throws InterruptedException {
        while (times != 5 && continueloop) {
            Thread produce = new Thread(() -> {
                synchronized (LOCK) {
                    if (!haveMinion) {
                        System.out.println("生产超级兵");
                        haveMinion = true;
                        LOCK.notifyAll();
                    }
                }
            });

            Thread move = new Thread(() -> {
                synchronized (LOCK) {
                    if (!haveMinion) {
                        try {
                            LOCK.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    } else {
                        System.out.println("超级兵移动");
                        haveMove = true;
                        LOCK.notifyAll();
                    }
                }
            });

            Thread attack = new Thread(() -> {
                synchronized (LOCK) {
                    if (!haveMinion || !haveMove) {
                        try {
                            LOCK.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    } else {
                        System.out.println("攻击防御塔");
                        LOCK.notifyAll();
                        haveMinion = false;
                        haveMove = false;
                        times += 1;
                    }
                }
            });

            produce.start();
            move.start();
            attack.start();

            produce.join();
            move.join();
            attack.join();

            if (times == 5)
                continueloop = false;
        }
    }
}
