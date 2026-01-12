import java.util.Scanner;

public class Homework {
    //    1.接收三个数字
    //    2.取出最小值:x比较y，min比较z
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int x = scanner.nextInt();
        int y = scanner.nextInt();
        int z = scanner.nextInt();
        int m = x < y ? x : y;
        int n = m < z ? m : z;
        System.out.println("最小值为："+n);
    }
}
