package com.coder.supermarket.bean;

import java.util.Random;

public class PersonInfoSource {
    public static Random random = new Random();
    private static final String LASTNAMES[] = {"李", "王", "张", "刘", "陈", "杨", "赵", "黄", "周", "吴",
            "徐", "孙", "胡", "朱", "高", "林", "何", "郭", "马", "罗",
            "梁", "宋", "郑", "谢", "韩", "唐", "冯", "于", "董", "萧"};

    private static final String FIRSTNAMES[] = {
            "伟", "芳", "娜", "秀英", "敏", "静", "丽", "星冉", "磊", "军",
            "洋", "勇", "艳", "杰", "娟", "涛", "明", "超", "秀兰", "霞",
            "平", "刚", "桂英", "玉兰", "萍", "毅", "浩", "宇", "轩", "怡",
            "文", "晨", "睿", "哲", "俊", "嘉", "博", "天", "乐", "佳",
            "欣", "彤", "琪", "萱", "婷", "雪", "梦", "悦", "颖", "琳"
    };

    private static final String SEXS[] = {"男", "女"};

    private static final String ACCOUNT_PASSWORD = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789!@#$%^&*()"; //72个

    public static String randomChineseName() {
        String lastName, firstName;
        int random1 = random.nextInt(30);
        int random2 = random.nextInt(50);
        lastName = LASTNAMES[random1];
        firstName = FIRSTNAMES[random2];
        return lastName + firstName;
    }

    public static String gender() {
        int r = random.nextInt(2);
        return SEXS[r];
    }

    public static int age() {
        return random.nextInt(38) + 18;
    }

    public static String account() {
        //生成一个10位账号
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < 10; i++) {
            int x = random.nextInt(72);
            stringBuilder.append(ACCOUNT_PASSWORD.charAt(x));
        }
        return stringBuilder.toString();
    }

    public static String password() {
        //生成一个10位密码
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < 10; i++) {
            int x = random.nextInt(72);
            stringBuilder.append(ACCOUNT_PASSWORD.charAt(x));
        }
        return stringBuilder.toString();
    }
}
