package com.coder.homework1;

import java.util.Scanner;

public class Absolute {
    //2. 定义一个方法，求一个整数的绝对值
    public static void main(String[] args) {
        System.out.println("请输入要取绝对值的整数：");
        Scanner scanner = new Scanner(System.in);
        int x = scanner.nextInt();
        absolute(x);
    }
    public static void absolute(int x) {
        System.out.println(x > 0 ? x : -x);
    }
}
