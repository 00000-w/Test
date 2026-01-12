package com.coder.homework1;

public class Teacher implements Runnable{
    private Thread thread;

    public Teacher(Thread thread) {
        this.thread = thread;
    }

    @Override
    public void run() {
        System.out.println("老师宣布：");
        for (int i = 0; i < 3; i++) {
            System.out.println("上课");
        }
        thread.interrupt();
    }
}
