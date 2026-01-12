import java.util.Scanner;

public class Homework2 {
    public static void main(String[] args) {
        //1.接收一个非0的1位整数赋给x
        //2.x*9赋给y
        //3.分支①如果y是两位数，个位十位相加赋给变量z；②y是个位数，赋给z
        //4.z*27+7
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入一个非0的1位整数");
        int x = scanner.nextInt();
        int y = x * 9;
        int z = y > 9 ? y/10+y%10 : y;
        System.out.println(z*27+7);
    }
}
