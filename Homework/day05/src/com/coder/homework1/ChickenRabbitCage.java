package com.coder.homework1;

public class ChickenRabbitCage {
    //使用循环解决计算鸡兔同笼问题：50 个头，120 只脚，问鸡和兔分别多少只
    public static void main(String[] args) {
        for(int i = 20; i <= 50; i++) {
            int j = 50 - i;
            boolean b = 2 * i + 4 * j == 120;
            if(b) {
                System.out.println("鸡有"+i+"只,兔有"+j+"只");
            }
        }
    }
}
