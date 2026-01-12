package com.coder.homework2;

import java.util.Random;

public class Turtle implements Runnable{
    @Override
    public void run() {
        Random random = new Random();
        int distance = 0;
        while (distance < 100 && Winner.getWinner() == null) {
            int i = random.nextInt(3) + 1;
            System.out.println("乌龟跑" + i + "米");
            distance += i;
        }
        
        Winner.setWinner("乌龟");
    }
}
