import java.util.Scanner;

public class Main2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        if (n >= 10000)
            return;
        int total = 0;
        for (int i = 1; i <= n; i++) {
            for (int j = 2; j < i; j++) {
                int k = i / j;
                if (k != j && k * j == i) {
                    total += 1;
                    break;
                }
            }
        }
        System.out.println(total);
    }
}
