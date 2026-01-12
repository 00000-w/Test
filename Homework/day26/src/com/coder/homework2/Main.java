package com.coder.homework2;

public class Main {
    public static void main(String[] args) {
        Cave cave = new Cave();
        new Thread(cave::pass, "李白").start();
        new Thread(cave::pass, "杜甫").start();
        new Thread(cave::pass, "白居易").start();
    }
}
