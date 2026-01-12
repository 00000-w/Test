package com.coder.homework1;

import java.util.Arrays;

public class Double {
    //1. 定义一个方法，实现将一组浮点数，四舍五入取 2 位小数
    //{3.1415,5.6789,4.523,7.658} {3.14,5.68,4.52,7.66}
    public static void main(String[] args) {
        double[] x = {3.1415,5.6789,4.523,7.658};
        double_2_round(x);
    }
    public static void double_2_round(double[] x) {
        for (int i = 0; i < x.length; i++) {
            int b = (int)(x[i] * 1000) + 5;
            b /= 10;
            x[i] = b * 1.0 / 100;
        }
        System.out.println(Arrays.toString(x));
    }
}
