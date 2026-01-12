package com.coder.homework1;

public class Pascal {
    /*5、使用二维数组打印杨辉三角形
1) 第 1 行有 1 个元素，第 n 行有 n 个元素
2) 每一行的第 1 个元素和最后一个元素都是 1
            3) 从第三行开始，对于非第一个元素和最后一个元素的值，都有如下算法
    X[i][j]=x[i-1][j-1]+x[i-1][j];*/
    public static void main(String[] args) {
        int[][] x = new int[10][10];
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                if (j > i) {
                    System.out.println();
                    break;
                } else if (j == 0 || j == i) {
                    x[i][j] = 1;
                    System.out.print(x[i][j]+"\t");
                } else {
                    x[i][j] = x[i-1][j-1] + x[i-1][j];
                    System.out.print(x[i][j]+"\t");
                }

            }

        }
    }


}