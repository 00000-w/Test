package com.coder.study.Arrays;

import java.util.Arrays;

public class EqualsCompare {
    public static void main(String[] args) {
        int[] x = {1, 2, 4, 6, 23, 646, 564};
        int[] y = {2, 5, 6, 46, 467, 245};
        //Array.equals(x, y);
        boolean b = Arrays.equals(x, y);
        System.out.println(b);
        //Array.compare(x, y);
    }
}
