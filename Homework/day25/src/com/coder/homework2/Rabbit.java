package com.coder.homework2;

import java.util.Random;
import java.util.concurrent.TimeUnit;

public class Rabbit implements Runnable{
    @Override
    public void run() {
        Random random = new Random();
        int distance = 0;
        while (distance <= 70 && Winner.getWinner() == null) {
            int i = random.nextInt(3) + 3;
            distance += i;
            System.out.println("兔子跑" + i + "米");
        }

        System.out.println("兔子跑超过70米，休息2毫秒");

        try {
            TimeUnit.MILLISECONDS.sleep(2);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        while (distance < 100 && Winner.getWinner() == null) {
            int i = random.nextInt(3) + 3;
            distance += i;
            System.out.println("兔子跑" + i + "米");
        }

        Winner.setWinner("兔子");
    }
}
