package com.coder.study;

public class Array {
    public static void main(String[] args) {
        int[] x = {1, 2, 3, 5, 6, 7, 3};
        //数组的属性，得到数组元素的个数
        for(int i = 0; i < x.length; i++) {
            int a = x[i];
            System.out.println(a);
            }
        //JDK5之后的增强循环，只针对数组、集合
        for(int a:x) {
            System.out.println(a);
        }
    }

}
