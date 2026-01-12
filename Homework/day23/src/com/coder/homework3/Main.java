package com.coder.homework3;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Date;
import java.util.Random;
import java.util.Scanner;
import java.util.concurrent.ThreadLocalRandom;

public class Main {
    public static void main(String[] args) {
        int num;
        int num1;
        System.out.println("请录入彩票类型(选3D请输入3,选5D请输入5)：");
        Scanner scanner = new Scanner(System.in);
        if (!scanner.hasNextInt()) {
            System.out.println("输入无效");
            return;
        } else {
            num = scanner.nextInt();
            if (num != 3 && num != 5) {
                System.out.println("输入无效");
                return;
            }
        }

        System.out.println("请输入您要投入的注数：");
        if (!scanner.hasNextInt()) {
            System.out.println("输入无效");
            return;
        } else {
            num1 = scanner.nextInt();
            if (num1 < 0) {
                System.out.println("输入无效");
                return;
            }
        }

        try (FileWriter writer = new FileWriter("D:/javaHomework.txt", true)) {
            for (int i = 0; i < num1; i++) {
                String content;
                if (num == 3) {
                    content = getSystemTime() + "\t" + getSerialNumber() + "\t" + get3DLotteryNumber();
                } else {
                    content = getSystemTime() + "\t" + getSerialNumber() + "\t" + get5DLotteryNumber();
                }
                writer.write(content + "\n");
            }
            System.out.println("写入成功");
        } catch (IOException e) {
            System.err.println("写入失败" + e.getMessage());
        }
    }

    public static String getSystemTime() {
        return new Date().toString();
    }

    public static long getSerialNumber() {
        return ThreadLocalRandom.current().nextLong(1000000000L, 9999999999L + 1);
    }

    public static String get5DLotteryNumber() {
        StringBuilder str = new StringBuilder();
        Random random = new Random();
        for (int i = 0; i < 5; i++) {
            str.append(random.nextInt(10));
        }
        return str.toString();
    }

    public static String get3DLotteryNumber() {
        StringBuilder str = new StringBuilder();
        Random random = new Random();
        for (int i = 0; i < 3; i++) {
            str.append(random.nextInt(10));
        }
        return str.toString();
    }
}


