package com.coder.study.Arrays;

import java.util.Arrays;

public class CopyOf {
    public static void main(String[] args) {
        //copyOf
        int[] x = {1, 2, 4, 6, 84, 524, 4};
        int[] y = Arrays.copyOf(x, 3);
        //copyOfRange
        int[] z = Arrays.copyOfRange(x, 1, 4);
        //System.arraycopy(x, 1, m, 0, 5)
    }
}
