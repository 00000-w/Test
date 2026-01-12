package com.coder.homework3;

import java.util.concurrent.locks.LockSupport;

public class Main {
    static Thread t1;
    static Thread t2;
    static Thread t3;

    public static void main(String[] args) {
        t3 = new Thread(() -> {
            for (int i = 0; i < 3; i++) {
                LockSupport.park();
                System.out.println("个人账户积分");
                LockSupport.unpark(t1);
            }

        });

        t2 = new Thread(() -> {
            for (int i = 0; i < 3; i++) {
                LockSupport.park();
                System.out.println("使用微信付款");
                LockSupport.unpark(t3);
            }
        });

        t1 = new Thread(() -> {
            for (int i = 0; i < 3; i++) {
                LockSupport.park();
                System.out.println("购买商品下单");
                LockSupport.unpark(t2);
            }
        });

        t1.start();
        t2.start();
        t3.start();
        LockSupport.unpark(t3);
    }
}
/*
static Thread t1;
    static Thread t2;
    static Thread t3;

    public static void main(String[] args) {

        BuyGoods1 buyGoods1 = new BuyGoods1(3);
        t1 = new Thread(() -> {
            buyGoods1.doBuyGoods("完成用户积分", t3);
        });
        t2 = new Thread(() -> {
            buyGoods1.doBuyGoods("用户微信支付", t1);
        });
        t3 = new Thread(() -> {
            buyGoods1.doBuyGoods("购买商品订单", t2);
        });
        t1.start();
        t2.start();
        t3.start();
        LockSupport.unpark(t3);
    }
}

class BuyGoods1 {
    private int num;

    public BuyGoods1(int num) {
        this.num = num;
    }

    public void doBuyGoods(String opName, Thread next) {
        for (int i = 1; i <= num; i++) {
            LockSupport.park();
            System.out.println("操作流程:" + opName);
            LockSupport.unpark(next);
        }
    }
}*/
