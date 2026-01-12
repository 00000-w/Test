package com.coder.supermarket.utils;

import java.util.Scanner;

public class InputUtils {
    private static Scanner scanner = new Scanner(System.in);

    //读取范围内整数，如果失败，一直读取
    public static int inputInt(int min, int max) {
        int result = 0;
        while (true) {
            try {
                String input = scanner.next();
                result = Integer.parseInt(input);
                if (result < min || result > max) {
                    System.out.println("范围有误，重新输入");
                    continue;
                }
                break;
            } catch (NumberFormatException e) {
                System.out.println("格式不对，重新输入");
            }
        }
        return result;
    }

    public static boolean inputBoolean() {
        boolean result = false;
        while (true) {
            String input = scanner.next();
            if ("y".equalsIgnoreCase(input)) {
                result = true;
                break;
            }
            if ("n".equalsIgnoreCase(input))
                break;
            System.out.println("格式有误，重新输入");
        }
        return result;
    }

    public static double inputDouble(double min, double max) {
        double result = 0;
        while (true) {
            try {
                String input = scanner.next();
                result = Double.parseDouble(input);
                if (result < min || result > max) {
                    System.out.println("范围有误，重新输入");
                    continue;
                }
                break;
            } catch (NumberFormatException e) {
                System.out.println("格式有误，重新输入");
            }
        }
        return result;
    }
}
