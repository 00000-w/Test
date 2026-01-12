import java.util.Scanner;
//switch里面套if没考虑到，0作为被除数的情况没考虑到
public class Homework3 {
    public static void main(String[] args) {
        //计算器
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入第一个数字");
        int num1 = scanner.nextInt();
        System.out.println("请输入第二个数字");
        int num2 = scanner.nextInt();
        System.out.println("请输入运算符：(+ - * /)");
        String op = scanner.next();
        switch(op) {
            case "+":
                System.out.println(num1+"+"+num2+"="+(num1+num2));
                break;
            case "-":
                System.out.println(num1+"-"+num2+"="+(num1-num2));
                break;
            case "*":
                System.out.println(num1+"*"+num2+"="+(num1*num2));
                break;
            case "/":
                if(num2 != 0) {
                    System.out.println(num1 + "/" + num2 + "=" + (num1 / num2));
                } else {
                    System.out.println("0不能作为被除数");
                }
                break;
            default:
                System.out.println("请输入正确的运算符");
                break;
        }
    }
}
