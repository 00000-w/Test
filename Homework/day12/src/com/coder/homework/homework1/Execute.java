package com.coder.homework.homework1;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Execute {
    public static void main(String[] args) {
        System.out.println("请输入一个摄氏温度:");
        Scanner scanner = new Scanner(System.in);
        double degree = 0;
        try {
            degree = scanner.nextInt();
        } catch (InputMismatchException e) {
            System.out.println("请输入数字");
            return;
        }
        double fahrenheit = 1.8 * degree + 32;
        System.out.println("摄氏度转化为华氏度为：" + fahrenheit);
    }
}
