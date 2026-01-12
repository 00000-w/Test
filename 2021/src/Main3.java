import java.util.Scanner;

public class Main3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        long m = 0;
        if (n <= 0)
            m = 1;
        else
            m = n;
        while (true) {
            if (m >= 200000000) {
                System.out.println("F");
                break;
            }
            long j = Long.parseLong(new StringBuilder(String.valueOf(m)).reverse().toString());
            long k = m * j;
            if (k >= 100000000 && k <= 200000000) {
                System.out.println(m);
                break;
            }
            m += 1;
        }
    }
}
