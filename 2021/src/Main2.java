import java.util.Scanner;

public class Main2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = 0;
        if (n <= 0) {
            m = 1;
        } else
            m = n;
        while (true) {
            if (m > 200000) {
                System.out.println("F");
                break;
            }
            int k = Integer.parseInt(new StringBuffer(String.valueOf(m)).reverse().toString());
            int j = Math.abs(k - m);
            if (j >= 100000 && j <= 200000) {
                System.out.println(m);
                break;
            }
            m += 1;
        }
    }
}
