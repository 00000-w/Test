import java.util.Scanner;

public class IfTest {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入一个整数");
        int b = scanner.nextInt();
        if(b % 2 == 0) {
            System.out.println("是偶数");
        }else{
            System.out.println("是奇数");
        }
    }
}
