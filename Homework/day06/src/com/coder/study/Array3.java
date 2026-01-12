package com.coder.study;

import java.util.Arrays;

public class Array3 {
    public static void main(String[] args) {
        int[] x = {3, 4, 5, 1, 6, 3};
        //快速排序
        Arrays.sort(x);
        for (int i : x) {
            System.out.println(i);
        }
    }
}
