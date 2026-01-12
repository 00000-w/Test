package com.coder.homework1;

import java.util.Arrays;

public class Balls {
    public static void main(String[] args) {
        //2、 根据双色球摇奖规则，产生 6 个红球 1 个蓝球；红球范围 1 - 33， 蓝球范围 1 - 16. 红球不能有重复的产生。
        int[] red = new int[6];
        int[] blue = new int[1];
        for (int i = 0; i < 6; i++) {
            red[i] = (int)(Math.random() * 33) + 1;
        }
        for (int i = 0; i < 6; i++) {
            for (int j = i + 1; j < 6; j++) {
                if(red[i] == red[j])
                    red[i] = (int)(Math.random() * 33 + 1);
            }
        }
        blue[0] = (int)(Math.random() * 16 + 1);
        System.out.println(Arrays.toString(red) + Arrays.toString(blue));
    }
}

