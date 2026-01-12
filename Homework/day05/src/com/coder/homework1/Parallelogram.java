package com.coder.homework1;

public class Parallelogram {
    //打印平行四边形
    public static void main(String[] args) {
        for(int i = 1; i <= 4; i++) {
            int d = i;
            while(d - 1 >= 0) {
                System.out.print("\t");
                d -= 1;
            }
            for(int j = 1; j <= 10; j++) {
                System.out.print("*");
            }
            System.out.println();
        }
    }
}
