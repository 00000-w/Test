package com.coder.homework.homework2;

import java.util.Scanner;

public class Execute {
    public static void main(String[] args) {
        System.out.println("请登记您的身份证：");
        Scanner scanner = new Scanner(System.in);
        String identity = scanner.next();
        try {
            IdentityFugtives.checkFugtive(identity);
        } catch (IdentityException e) {
            System.out.println("登记失败！" + e.getMessage());
            return;
        }
        System.out.println("登记成功");
    }
}
