package homework;

import java.util.Scanner;

public class Homework3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入第一个数字：");
        double x = scanner.nextDouble();
        System.out.println("请输入第二个数字：");
        double y = scanner.nextDouble();
        System.out.println("请输入运算符(+ - * /)：");
        String z = scanner.next();
        double r = 0;
        switch(z) {
            case "+":
                r = x + y;
                break;
            case "-":
                r = x - y;
                break;
            case "*":
                r = x * y;
                break;
            case "/":
                if(y == 0) {
                    System.out.println("0不能作为被除数");
                } else {
                    r = x / y;
                }
                break;
            default:
                System.out.println("请输入正确的运算符");
                break;
        }
        if(r % 1 == 0) {
            int m = (int)r;
            System.out.println("计算的结果为："+m);
        } else {
            System.out.println("计算的结果为："+r);
        }
    }
}

