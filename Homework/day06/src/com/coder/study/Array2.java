package com.coder.study;

public class Array2 {
    public static void main(String[] args) {
        int[] x = {1, 2, 4, 5, 6, 6};
        int[] y = {3, 3, 675, 8, 20};
        int[] z = new int[x.length + y.length];
        for (int i = 0; i < z.length; i++) {
            z[i] = x[i];

        }
    }
}
