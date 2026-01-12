package homework;

import java.util.Scanner;

public class Homework4 {
    public static void main(String[] args) {
        //1.从键盘接收一个年份和月份
        //2.判断该月份的最大天数(考虑闰年和平年的问题)
        /*闰年算法：能被 4 整除，不能被 100 整除，或者能被 400 整除*/

        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入一个年份、月份：");
        int year = scanner.nextInt();
        int month = scanner.nextInt();
        if (year < 0 || month < 1 || month > 12) {
            System.out.println("请确保您的年份、月份输入正确");
        }
        switch (month) {
            case 1:
            case 3:
            case 5:
            case 7:
            case 8:
            case 10:
            case 12:
                System.out.println("该月的最大天数为31");
                break;
            case 4:
            case 6:
            case 9:
            case 11:
                System.out.println("该月的最大天数为30");
                break;
            case 2:
                if (year % 4 == 0) {
                    if (year % 100 != 0) {
                        System.out.println("该月的最大天数为29");
                    } else if (year % 400 == 0) {
                        System.out.println("该月的最大天数为29");
                    } else {
                        System.out.println("该月的最大天数为28");
                    }
                } else {
                    System.out.println("该月的最大天数为28");
                }
        }
    }
}