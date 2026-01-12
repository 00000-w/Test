package com.coder.study.Arrays;

import java.util.Arrays;

public class BinarySearch {
    public static void main(String[] args) {
        //二分查找（一定要先排序）
        int x[] = {1, 3, 7, 8, 5, 7, 9, 4};
        Arrays.sort(x);
        System.out.println(Arrays.binarySearch(x, 33));
    }
}
