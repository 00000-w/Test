import java.util.Scanner;

public class Homework1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入一个数字");
        int x = scanner.nextInt();
        //既能被3又能被5整除要放在最上面，第一个被运行
        if(x % 3 == 0 && x % 5 == 0) {
            System.out.println("乒乓");
        } else if(x % 3 == 0) {
            System.out.println("乒");
        } else if (x % 5 == 0) {
            System.out.println("乓");
        } else {
            System.out.println(x);
        }
    }
}
