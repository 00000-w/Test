package com.coder.homework3;

public class Man implements  Person {
    @Override
    public void eat() {
        System.out.println("男人吃饭");
    }

    @Override
    public void sleep() {
        System.out.println("男人睡觉");
    }

    @Override
    public void speak() {
        System.out.println("男人说话");
    }
}
