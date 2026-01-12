package com.coder.homework1;

import java.util.Scanner;

public class Nation {
    //5. 定义一个方法，判断给定的国家，是否是联合国常任理事国
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入您要判断的国家：");
        String x = scanner.next();
//        System.out.println(nation(x));
        nation(x);
    }
//    public static String nation(String x) {
    public static void nation(String x) {
        String[] y = {"美国", "中国", "英国", "法国", "俄罗斯"};
        for(String a : y) {
           if(x.equals(a)) {
               System.out.println("是联合国常任理事国");
               return;
           }
        }
        System.out.println("不是联合国常任理事国");
    }
}
