package com.coder.homework2;

import java.util.Scanner;

/*实现聊天过滤器，完成功能如下：用户从键盘录入聊天内容，系统会对聊天内容进行过
滤，如果出现了限定文字，对其进行替换成*号处理(几个字替换成几个*号)*/
public class Chat {
    public static void main(String[] args) {
        System.out.println("请输入您的对话：");
        Scanner scanner = new Scanner(System.in);
        String chat = scanner.nextLine();
        check(chat);
    }

    public static void check(String chat) {
        String[] regex = {"黄赌毒", "脏话"};
        char[] x = chat.toCharArray();
        for (int i = 0; i < regex.length; i++) {
            if (chat.indexOf(regex[i]) != -1) {
                for (int j = chat.indexOf(regex[i]); j < chat.indexOf(regex[i]) + regex[i].length(); j++) {
                    x[j] = '*';
                }
            }

        }
        String afterCheckChat = new String(x);
        System.out.println("经过净化，您的对话内容为：" + afterCheckChat);
    }
}
