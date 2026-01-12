package com.coder.homework3;

public class Main {
    static final Object LOCK = new Object();
    static boolean haveMinion = false;
    public static void main(String[] args) {
        Thread produceThread = new Thread(()-> {
            synchronized (LOCK) {
                while (!haveMinion) {
                    System.out.println("生产超级兵");
                    haveMinion = true;
                }
                System.out.println("已有超级兵，指令小兵攻击防御塔");
                LOCK.notifyAll();
            }
        }, "生产线程");


        Thread attackThread = new Thread(() -> {
            synchronized (LOCK) {
                if (!haveMinion) {
                    try {
                        LOCK.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                System.out.println("攻击防御塔");
            }
        }, "攻击线程");

        produceThread.start();
        attackThread.start();
    }
}
