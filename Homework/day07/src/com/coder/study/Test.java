package com.coder.study;

import java.util.Scanner;
//这里犯了一个大错，字符串的比较不是用==,而是equals

public class Test {
    public static void main(String[] args) {
        String[] x = {"哈哈哈", "哈哈", "哈"};
        Scanner scanner = new Scanner(System.in);
        String y = scanner.next();
      /*  for(String a : x) {
            if(y == a) {
                System.out.println("yes");
            }
        }*/
        for (int i = 0; i < 3; i++) {
            if(y == x[i])
                System.out.println("yes");
            else {
                System.out.println("no");
            }
        }
    }
}
