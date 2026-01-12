import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String regex = "^[01]+$";
        String a = scanner.next();
        String b = scanner.next();
        Pattern pattern = Pattern.compile(regex);
        Matcher matcherA = pattern.matcher(a);
        Matcher matcherB = pattern.matcher(b);
        if (matcherA.matches() && matcherB.matches()) {
            twoToTen(trans(a) + trans(b));
            return;
        }
        System.out.println("不符合输入规范");
    }

    public static int trans(String num) {
        int sum = 0;
        for (int i = num.length() - 1; i >= 0; i--) {
            sum += Integer.parseInt(String.valueOf(num.charAt(i))) * Math.pow(2, num.length() - 1 - i);
        }
        return sum;
    }

    public static void twoToTen(int two) {
        StringBuilder sb = new StringBuilder();
        while (true) {
            if (two / 2 == 0) {
                sb.append(two % 2);
                System.out.println(sb.reverse());
                break;
            }
            int yu = two % 2;
            sb.append(yu);
            two /= 2;
        }
    }
}
