package com.coder.homework1;

import java.util.Arrays;

public class ArrayOrder {
    public static void main(String[] args) {
        //1、判断一个数组是否有序
        int[] x = {23, 45, 54, 7234, 345, 356};
        int[] y = Arrays.copyOf(x, x.length);
        Arrays.sort(y);
        System.out.println(Arrays.equals(x, y) ? "有序" : "无序");
    }
}
