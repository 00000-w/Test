package com.coder.homework2;

import java.util.concurrent.TimeUnit;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        Thread rabbitThread = new Thread(new Rabbit());
        Thread turtleThread = new Thread(new Turtle());
        rabbitThread.start();
        turtleThread.start();
        TimeUnit.SECONDS.sleep(2);
        System.out.println(Winner.getWinner() + "率先达到终点，" + Winner.getWinner() + "获得比赛胜利");
    }
}
