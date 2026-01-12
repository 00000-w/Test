package com.coder.homework1;

public class PerfectNumber {
    //输出 100 以内的所有完数(所有的真因子和正好等于它本身，例如 6=1+2+3)28=1+2+4+7+14
    public static void main(String[] args) {
        for(int i = 1; i <= 100; i++) {
            int sum = 1;
            for(double j = 2; j < i; j++) {
                if(i / j % 1 == 0) {
                    sum += j;
                }
                if(sum == i && j == i - 1) {
                    System.out.print(i+"\t");
                }
            }
        }
    }
}
