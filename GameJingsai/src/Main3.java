import java.util.ArrayList;
import java.util.Scanner;

public class Main3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String x1 = scanner.next();
        String x2 = scanner.next();
        int[] a = new int[x1.length()];
        int[] b = new int[x2.length()];
        for (int i = 0; i < x1.length(); i++) {
            a[i] = Integer.parseInt(String.valueOf(x1.charAt(i)));
        }
        for (int i = 0; i < x2.length(); i++) {
            b[i] = Integer.parseInt(String.valueOf(x2.charAt(i)));
        }
        System.out.println(bi(trans(a) + trans(b)));

    }
    public static int trans(int[] x) {
        int sum = 0;
        for (int i = 0; i < x.length; i++) {
            sum += x[i] * Math.pow(2, x.length - 1 - i);
        }
        return sum;
    }
    public static String bi(int x) {
        ArrayList<Integer> list = new ArrayList();
        while (x != 0) {
            list.add(x % 2);
            x = x / 2;
        }
        String str = "";
        for (Integer num : list) {
            str = num + str;
        }
        return str;
    }
}
