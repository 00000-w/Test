package com.coder.study;

public class Study {
    public static void main(String[] args) {
        //声明一个数组的方法，推荐用第一种
        int[] x;
        int []y;
        int z[];
        //静态创建数组
        x = new int[] {1, 2, 3};
        //打印数组的值
        System.out.println(x[0]);
        System.out.println(x[1]);
        System.out.println(x[2]);
        //声明和创建可以一起写
        int[] m = new int[] {1, 2, 3};
        //简化写法,这种写法要求声明和创建必须一起写，在一行代码上
        double[] n = {1.1, 1.2, 1.3};
        //动态创建数组
        int[] l = new int[5];
        System.out.println(l[0]);
        System.out.println(l[3]);
        //为数组的元素赋值
        l[3] = 3;
        System.out.println(l[3]);
    }
}
