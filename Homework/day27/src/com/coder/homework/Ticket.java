package com.coder.homework;

public class Ticket implements Runnable {
    private static int num = 10;
    private  String name;

    Ticket(String name) {
        this.name = name;
    }

    public int getNum() {
        return num;
    }

    public  String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

/*    public  void snapUp() {
        if (num > 0) {
            num -= 1;
            System.out.println("旅客" + getName() + "已成功买票，还剩" + num + "张");
        } else {
            System.out.println("抢票失败");
        }
    }*/

    @Override
    public void run() {
        synchronized (Ticket.class) {
            if (num > 0) {
                num -= 1;
                System.out.println(getName() + "已成功买票，还剩" + num + "张");
            } else {
                System.out.println(getName() + "抢票失败");
            }
        }
    }
}

