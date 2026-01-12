import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine();
        String str2 = scanner.nextLine();
        String intRegex = "^\\d*A-F*a-f*$";
        Pattern pattern = Pattern.compile(intRegex);
        Matcher matcher = pattern.matcher(str);
        Matcher matcher2 = pattern.matcher(str2);

        String doubleRegex = "^(\\d*A-F*a-f*\\d*)+\\.(\\d*A-F*a-f*)+$";
        Pattern pattern2 = Pattern.compile(doubleRegex);
        Matcher doubleMatcher1 = pattern2.matcher(str);
        Matcher doubleMatcher2 = pattern2.matcher(str2);

        if(matcher.matches() && matcher2.matches()) {
            System.out.println(intCompare(str, str2));
        } else if (doubleMatcher1.matches() && doubleMatcher2.matches()) {
                StringBuilder sb1 = new StringBuilder();
                StringBuilder sb2 = new StringBuilder();
                if (doubleMatcher1.find() && doubleMatcher2.find()) {
                    String first1 = doubleMatcher1.group(1);
                    String first2 = doubleMatcher1.group(2);
                    doubleMatcher1.appendReplacement(sb1, first1);
                    doubleMatcher1.appendTail(sb1);
                    String second1 = doubleMatcher2.group(1);
                    String second2 = doubleMatcher2.group(2);
                    doubleMatcher2.appendReplacement(sb2, second1);
                    doubleMatcher2.appendTail(sb2);
                    if (!intCompare(sb1.toString(), sb2.toString()).equals("等于"))
                        System.out.println(intCompare(sb1.toString(), sb2.toString()));
                    else {
                        sb1 = new StringBuilder();
                        sb2 = new StringBuilder();
                        doubleMatcher1.appendReplacement(sb1, first2);
                        doubleMatcher1.appendTail(sb1);
                        doubleMatcher2.appendReplacement(sb2, second2);
                        doubleMatcher2.appendTail(sb2);
                        String doubleString1 = sb1.toString();
                        String doubleString2 = sb2.toString();
                        int i = 0;
                        while (true) {
                            if (doubleString1.charAt(i) > doubleString2.charAt(i))
                                System.out.println("大于");
                            else if (doubleString1.charAt(i) < doubleString2.charAt(i))
                                System.out.println("小于");
                            else {
                                if (doubleString1.charAt(i + 1) == '\0' && doubleString2.charAt(i + 1) != '\0')
                                    System.out.println("小于");
                                else if (doubleString2.charAt(i + 1) == '\0' && doubleString1.charAt(i + 1) != '\0')
                                    System.out.println("大于");
                                else if (doubleString1.charAt(i + 1) == '\0' && doubleString2.charAt(i + 1) == '\0')
                                    System.out.println("等于");
                                i += 1;
                                continue;
                            }
                        }
                    }

                }
        } else
            System.out.println("不符合输入规范");

    }
    public static String intCompare(String str, String str2) {
        if (str.length() > str2.length())
            return "大于";
        if (str.length() < str2.length())
            return "小于";
        if (str.length() == str2.length()) {
            for (int i = 0; i < str.length(); i++) {
                if (str.charAt(i) > str2.charAt(i)) {
                    return "大于";
                } else if (str.charAt(i) == str2.charAt(i)) {
                    if (i == str.length() - 1)
                        return "等于";
                    else
                        continue;
                } else
                    return "小于";
            }
        }
        return "-1";
    }
}
