package com.coder.homework1;

public class Rice {
    public static void main(String[] args) {
        for (int i = 1; i <= 9; i++) {
            System.out.println();
            if (i == 5) {
                System.out.print(" * * * * * * * * * * * * * ");
            } else {
                for (int j = 1; j <= 9; j++) {
                    if (j == 5)
                        System.out.print(" * ");
                    else if (j == i || j == 10 - i)
                        System.out.print(" * ");
                    else
                        System.out.print("   ");
                }
            }

        }
    }
}
