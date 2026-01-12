package com.coder.homework1;

import java.util.Scanner;

public class Prime {
    public static void main(String[] args) {
        //从键盘接收一个数字，判断是否是素数(大于 1 的自然数，除了 1 和本身，不再有其他因数的数字) 2 3 5 7 11
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入需要判断是否为素数的数字：");
        int x = scanner.nextInt();
        if(x <= 1) {
            System.out.println("不是素数");
        }
        if(x == 2) {
            System.out.println("是素数");
        }
        double d = x;
        for (int i = 2; i <= x - 1; i++) {
            if((d / i) % 1 == 0) {
                System.out.println("不是素数");
                break;
            }else {
                System.out.println("是素数");
                break;
            }
        }
    }
}
