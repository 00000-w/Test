package com.coder.homework1;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

public class Main {
    public static void main(String[] args) {
        FutureTask<Integer> task = new FutureTask<>(() -> {
            int sum = 0;
            for (int i = 1; i <= 1000; i++) {
                sum += i;
            }
            return sum;
        });

        new Thread(task).start();

        try {
            System.out.println("1 + 2 + ... + 1000 = " + task.get());
        } catch (ExecutionException | InterruptedException e) {
            e.printStackTrace();
        }
    }
}
