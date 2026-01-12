package com.coder.study;

import java.util.Arrays;

public class ArraysTool {
    //toString
    public static void main(String[] args) {
        int[] x = {2, 4 ,56, 78, 11, 2235, 52};
        String r = Arrays.toString(x);
        System.out.println(Arrays.toString(x));
        for (int i : x) {
            System.out.println(i);
        }
        //Arrays.fill-全部替换
        Arrays.fill(x, 100);
        //Arrays.fill-部分替换
        Arrays.fill(x, 1, 3, 200);
        /*
        所有这样的范围，java统一规范，[前，后)
        */
    }
}
