import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.next();
        if (input.length() >= 1000) {
            System.out.println("表达式长度过长");
            return;
        }
        String regex = "\\-?\\d+([-*]?\\-?\\d+)*";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(input);
        if (!matcher.matches()) {
            System.out.println("表达式非法");
            return;
        }
        if (input.contains("-")) {
            String subRegex = "(\\-?\\d+)\\-(\\-?\\d+)";
            Pattern subPattern = Pattern.compile(subRegex);
            while (true) {
                Matcher subMatcher = subPattern.matcher(input);
                if (subMatcher.find()) {
                    String result = String.valueOf(Integer.parseInt(subMatcher.group(1)) - Integer.parseInt(subMatcher.group(2)));
                    StringBuilder sb = new StringBuilder();
                    subMatcher.appendReplacement(sb, result);
                    subMatcher.appendTail(sb);
                    input = sb.toString();
                } else
                    break;
            }
        }
        if (input.contains("*")) {
            String mulRegex = "(\\-?\\d+)\\*(\\-?\\d+)";
            Pattern mulPattern = Pattern.compile(mulRegex);
            while (true) {
                Matcher mulMatcher = mulPattern.matcher(input);
                if (mulMatcher.find()) {
                    String result = String.valueOf(Integer.parseInt(mulMatcher.group(1)) * Integer.parseInt(mulMatcher.group(2)));
                    StringBuilder sb = new StringBuilder();
                    mulMatcher.appendReplacement(sb, result);
                    mulMatcher.appendTail(sb);
                    input = sb.toString();
                } else
                    break;
            }
        }
        System.out.println(input);
    }
}
