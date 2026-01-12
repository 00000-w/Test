import java.util.Arrays;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String regex = "^\\d+$";
        String str = scanner.next();
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(str);
        if (!matcher.matches()) {
            System.out.println("输入不符合规范");
            return;
        }
        //全是0
        String zeroAll = "^0+$";
        Pattern zeroAllP = Pattern.compile(zeroAll);
        Matcher zeroAllM = zeroAllP.matcher(str);
        if (zeroAllM.matches()) {
            System.out.println("0");
            return;
        }

        //开头是0
        String zeroHead = "^0+[1-9]+$";
        Pattern zeroHeadP = Pattern.compile(zeroHead);
        Matcher zeroHeadM = zeroHeadP.matcher(str);
        if (zeroHeadM.matches()) {
            int zeroNum = 0;
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < str.length(); i++) {
                if (str.charAt(i) == '0') {
                    zeroNum += 1;
                    continue;
                } else
                    sb.append(str.charAt(i));
            }
            char[] c = sb.toString().toCharArray();
            Arrays.sort(c);
            for (int j = 0; j < c.length; j++) {
                if (j == 0) {
                    System.out.print(c[0]);
                    for (int k = 0; k < zeroNum; k++) {
                        System.out.print("0");
                    }
                } else {
                    System.out.print(c[j]);
                }
            }
            return;
        }

        //正常情况
        StringBuilder sb = new StringBuilder();
        int zeroNum = 0;
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == '0') {
                zeroNum += 1;
                continue;
            } else {
                sb.append(str.charAt(i));
            }
        }
        char[] chars = sb.toString().toCharArray();
        Arrays.sort(chars);
        for (int j = 0; j < chars.length; j++) {
            if (j == 0) {
                System.out.print(chars[0]);
                for (int k = 0; k < zeroNum; k++) {
                    System.out.print("0");
                }
            } else
                System.out.print(chars[j]);
        }
    }
}
