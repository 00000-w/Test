import java.util.Scanner;

public class Main1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        long n = scanner.nextLong();
        while (true) {
            if (n > 200000) {
                System.out.println("F");
                break;
            }
            long m = Long.parseLong(new StringBuffer(String.valueOf(n)).reverse().toString());
            if (m * n >= 100000 && m * n <= 200000) {
                System.out.println(n);
                break;
            }
            n += 1;
        }
    }
}
