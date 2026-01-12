package com.coder.homework1;

public class Search {
    //4. 定义一个方法，查找一个整数数组中，是否包含给定值{12,23,31,56,43,67} 31
    public static void main(String[] args) {
        search(32);
    }
    public static void search(int x) {
        int[] y = {12, 23, 31, 56, 43, 67};
        for(int a : y) {
            if(a == x) {
                System.out.println("yes");
                return;
            }
        }
        System.out.println("no");
    }
}
