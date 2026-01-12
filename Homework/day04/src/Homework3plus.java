import java.util.Scanner;
public class Homework3plus {
    public static void main(String[] args) {
        //计算器
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入第一个数字");
        int num1 = scanner.nextInt();
        System.out.println("请输入第二个数字");
        int num2 = scanner.nextInt();
        System.out.println("请输入运算符：(+ - * /)");
        String r = "";
        String op = scanner.next();
        switch(op) {
            case "+":
                r = num1+"+"+num2+"="+(num1+num2);
                break;
            case "-":
                r = num1+"-"+num2+"="+(num1-num2);
                break;
            case "*":
                r = num1+"*"+num2+"="+(num1*num2);
                break;
            case "/":
                if(num2 != 0) {
                    r = num1+"/"+num2+"="+(num1/num2);
                } else {
                    r = "0不能作为被除数";
                }
                break;
            default:
                r = "请输入正确的运算符";
        }
        System.out.println(r);
    }
}


