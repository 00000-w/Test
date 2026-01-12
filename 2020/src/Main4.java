import java.util.Arrays;
import java.util.Scanner;

public class Main4 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        if (n >= 1000)
            return;
        int m = scanner.nextInt();
        if (m >= n)
            return;
        double[] eggs = new double[n];
        for (int i = 0; i < n; i++) {
            eggs[i] = scanner.nextDouble();
        }
        Arrays.sort(eggs);
        double sum = 0;
        for (int i = n - 1; i > n - 1 - m; i--) {
            sum += eggs[i];
        }
        System.out.println(String.format("%.2f", sum));
    }
}
