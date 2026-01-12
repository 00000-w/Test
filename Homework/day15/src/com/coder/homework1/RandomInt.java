package com.coder.homework1;

import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;

public class RandomInt {
    public static void main(String[] args) {
        //实现每隔 2 秒钟，生成一个 1000 以内的随机整数，打印到屏幕上
        Random random = new Random();
        Timer timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                System.out.println(random.nextInt(1000));
            }
        }, 0, 2000);
    }
}
