package com.coder.homework1;

public class Z {
    public static void main(String[] args) {
        for(int i = 1; i <= 10; i++) {
            int d = 10 - i;
            if(i == 1 || i == 10) {
                System.out.println("**********");
            } else {
                while(d - 1 >= 0) {
                    System.out.print(" ");
                    d -= 1;
                }
                System.out.println("*");
            }

        }
    }
}
