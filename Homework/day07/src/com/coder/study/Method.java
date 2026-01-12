package com.coder.study;

public class Method {
    public static void main(String[] args) {
        eat("我", 4);
        eat("你", 2);
        System.out.println(add(3, 4));
    }
    //方法的定义
    public static void eat(String type, int num) {
        System.out.println(type + "吃饭");
        System.out.println(type + "吃完");
        System.out.println("一共吃了" + num + "碗饭");
    }
    //实现两个整数之和
    public static int add(int x, int y) {
        return x + y;
    }
}
