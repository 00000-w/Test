package com.coder.homework3;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Scanner;

public class Number {
    public static void main(String[] args) {
        //从键盘接收一行具有数字值的字符串，多个数字之间用逗号隔开，对所有数字扩大 10 倍，
        //并按四舍五入保留 2 位小数
        System.out.println("请输入一行具有数字值的字符串，多个数字请用逗号隔开");
        Scanner scanner = new Scanner(System.in);
        String[] x = scanner.nextLine().split(",");
        Double[] d = new Double[x.length];
        BigDecimal bigDecimal1 = new BigDecimal("1.0");
        System.out.println("这些数字经过扩大十倍、四舍五入保留两位小数，得到：");
        for (int i = 0; i < x.length; i++) {
            d[i] = Double.parseDouble(x[i]);
            d[i] *= 10.0;
            BigDecimal bigDecimal = new BigDecimal(d[i]);
            System.out.print(bigDecimal.divide(bigDecimal1, 2, RoundingMode.HALF_UP) + "\t");
        }
    }
}
