package com.coder.homework2;

import java.util.Scanner;

public class Execute {
    public static void main(String[] args) {
        //用户输入
        System.out.println("请输入姓名:");
        Scanner scanner = new Scanner(System.in);
        String name = scanner.next();
        System.out.println("请输入密码:");
        String password = scanner.next();

        //姓名判断
        char[] nameArray = name.toCharArray();
        int index = 0;
        for (char a : nameArray) {
            if (!Character.isLetter(a))
                index += 1;
        }
        if (index != 0)
            System.out.println("姓名不符合规范（必须全为英文）");

        //密码判断
        char[] passwordArray = password.toCharArray();
        int indexUpper = 0;
        int indexLower = 0;
        int indexDigit = 0;
        for (char a : passwordArray) {
            if (Character.isUpperCase(a))
                indexUpper += 1;
            if (Character.isLowerCase(a))
                indexLower += 1;
            if (Character.isDigit(a))
                indexDigit += 1;
        }
        if (indexUpper == 0 || indexLower == 0 || indexDigit == 0)
            System.out.println("密码不符合规范(密码中必须包含数字、大写字母、小写字母)");
    }
}
