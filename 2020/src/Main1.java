import java.util.Scanner;

public class Main1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        if (n >= 10000)
            return;
        int a = scanner.nextInt();
        if (a >= n)
            return;
        int total = 0;
        for (int i = 1; i <= n; i ++) {
            if (i % 2 == 0 && i % a == a - 1) {
                total += 1;
            }
        }
        System.out.println(total);
    }
}
