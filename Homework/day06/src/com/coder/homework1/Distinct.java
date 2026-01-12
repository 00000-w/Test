package com.coder.homework1;

import java.util.Arrays;

public class Distinct {
    public static void main(String[] args) {
        //数组去重{1, 2, 3, 4, 2, 1, 3, 5, 6, 9, 5} 返回出来的结果{1, 2, 3, 4, 5, 6, 9}
        int[] x = {1, 2, 3, 4, 2, 1, 3, 5, 6, 9, 5};
        int index = 0;
        for (int i = 0; i < x.length; i++) {
            for (int j = i + 1; j < x.length; j++) {
                if(x[i] != 0 && x[i] == x[j]) {
                    x[j] = 0;
                    index += 1;
                }
            }
        }
        Arrays.sort(x);
        int[] y = Arrays.copyOfRange(x, index, x.length);
        System.out.println(Arrays.toString(y));
    }
}
