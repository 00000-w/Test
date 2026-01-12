package com.coder.homework1;

import java.util.Scanner;

public class Lottery {
    //3. 定义一个方法，可接受彩票类型(3D 彩票或 5D 彩票)和购买注数，返回彩票号码
    //3D 彩票:由 3 个数字组成，0-9 的数字，可重复
    //2 3 4
    //1 2 3
    //5D 彩票:由 5 个数字组成, 0-9 的数字，可重复 2 2 4 6 9
    public static void main(String[] args) {
        System.out.println("请选择您的彩票类型（3.3D或5.5D）及购买注数：");
        Scanner scanner = new Scanner(System.in);
        int x1 = scanner.nextInt();
        int x2 = scanner.nextInt();
        type_and_times(x1, x2);
    }

    public static void type_and_times(int x, int y) {
        if(y <= 0 && x != 3 && x != 5)
            System.out.println("请确保您的彩票类型和购入注数输入正确");
        else if(y > 0) {
            if(x == 3) {
                while(y > 0) {
                    System.out.println(random() + "\t" + random() + "\t" + random());
                    y -= 1;
                }
            } else if(x == 5) {
                while(y > 0) {
                    System.out.println(random() + "\t" + random() + "\t" + random() + "\t" + random() + "\t" + random());
                    y -= 1;
                }
            } else {
                System.out.println("请输入正确的彩票类型");
                return;
            }
        } else {
            System.out.println("请确保您的购入注数输入正确");
        }
    }

    public static int random() {
        return (int)(Math.random() * 10);
    }

}
