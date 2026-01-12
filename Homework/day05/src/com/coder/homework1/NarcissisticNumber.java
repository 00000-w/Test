package com.coder.homework1;

public class NarcissisticNumber {
    //打印 1000 以内的水仙花数(水仙花数是一个三位数，水仙花数=百位 3 次方+十位 3 次方+个位 3 次方)
    public static void main(String[] args) {
        for(int i = 100; i < 1000; i++) {
            int a, b, c;
            a = i / 100;
            b = i / 10 % 10;
            c = i % 10;
            boolean d = a * a * a + b * b * b + c * c * c == i;
            if(d) {
                System.out.println(i);
            }
        }
    }
}
