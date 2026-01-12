package com.coder.homework1;

public class Poke {
    //4、使用二维数组生成一副扑克牌(除去大王、小王)
    public static void main(String[] args) {
        String[][] poker = new String[4][13];
        String[] suits = {"黑桃", "红心", "梅花", "方块"};
        String[] num = {"A", "2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K"};
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 13; j++) {
                poker[i][j] = suits[i] + num[j];
                System.out.print(poker[i][j]+"\t");
            }
            System.out.println();
        }
    }
}
