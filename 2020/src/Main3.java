import java.util.Scanner;

public class Main3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        if (n >= 10000)
            return;
        int total = 0;
        for (int i = 1; i <= n; i++) {
            int l = (int)Math.pow(i, 3);
            if (Math.sqrt(l) % 1 == 0) {
                total += 1;
            }
        }
        System.out.println(total);
    }
}
