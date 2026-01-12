package com.coder.homework1;

public class PrimeWithin100 {
    //输出 100 以内的所有素数
    public static void main(String[] args) {
        out:
        for(int i = 2; i < 100; i++) {
            if(i == 2) {
                System.out.println(i);
                continue;
            }
            int index = 0;
            for(double j = 2; j < i; j++) {
                if(i / j % 1 == 0) {
                    continue out;
                }else {
                    index += 1;
                    if(index == i - 2) {
                        System.out.println(i);
                    }
                }
            }
        }
    }
}
