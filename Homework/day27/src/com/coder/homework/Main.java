package com.coder.homework;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {
    public static void main(String[] args) {
        ExecutorService service = Executors.newFixedThreadPool(10);
        Ticket[] tickets = new Ticket[30];
        for (int i = 0; i < 30; i++) {
            tickets[i] = new Ticket("旅客" + i);
        }

        for (int i = 0; i < 10; i++) {
            new Thread(tickets[i]).start();
        }
    }
}
