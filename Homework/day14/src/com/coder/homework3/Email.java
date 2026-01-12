package com.coder.homework3;

import java.util.Scanner;

//从键盘接收邮箱地址，多个邮箱使用分号分隔，分别对每个邮箱地址做验证，如果是正
//确地址，则提示该地址邮件发送成功，如果是错误地址，则提示该地址邮件发送失败，并统
//计一共成功发送了几封邮件，有几封邮件是发给 qq 邮箱的
public class Email {
    private static int success = 0;
    private static int qqSuccess = 0;
    public static void main(String[] args) {

        System.out.println("请输入邮箱地址，若有多个邮箱地址，用分号分隔");
        Scanner scanner = new Scanner(System.in);
        String emails = scanner.nextLine();
        emails = emails.replace("；", ";");
        String[] email = emails.split(";");
        for (int i = 0; i < email.length; i++) {
            System.out.print("第" + (i + 1) + "封");
            checkEmailAddress(email[i]);
        }
        System.out.println("一共成功发出了" + success + "封邮件");
        System.out.println("有" + qqSuccess + "是发送给qq邮箱的");
    }

    public static void checkEmailAddress(String email) {
        String regex = "^[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,}$";
        String qqRegex = "^[A-Za-z0-9._%+-]+@qq\\.com$";
        if (email.matches(regex)) {
            System.out.println("地址邮件发送成功");
            success += 1;
            if (email.matches(qqRegex))
                qqSuccess += 1;
        }
        else
            System.out.println("地址邮件发送失败");
    }
}
