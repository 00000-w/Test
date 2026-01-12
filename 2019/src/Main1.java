import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入合法的数学表达式");
        String input = scanner.next();
        if (input.length() >= 1000) {
            System.out.println("表达式过长");
            return;
        }
        String regex = "^\\d+([*+]\\d+)*$";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(input);
        if (!matcher.matches()) {
            System.out.println("表达式不合法");
            return;
        }
        if (input.contains("+")) {
            String addRegex = "(\\d+)\\+(\\d+)";
            Pattern addPattern = Pattern.compile(addRegex);
            while (true) {
                Matcher addMatcher = addPattern.matcher(input);
                if (addMatcher.find()) {
                    int result = Integer.parseInt(addMatcher.group(1)) + Integer.parseInt(addMatcher.group(2));
                    StringBuilder sb = new StringBuilder();
                    addMatcher.appendReplacement(sb, String.valueOf(result));
                    addMatcher.appendTail(sb);
                    input = sb.toString();
                } else
                    break;
            }
        }
        if (input.contains("*")) {
            String mulRegex = "(\\d+)\\*(\\d+)";
            Pattern mulPattern = Pattern.compile(mulRegex);
            while (true) {
                StringBuilder sb = new StringBuilder();
                Matcher mulMatcher = mulPattern.matcher(input);
                if (mulMatcher.find()) {
                    int result = Integer.parseInt(mulMatcher.group(1)) * Integer.parseInt(mulMatcher.group(2));
                    mulMatcher.appendReplacement(sb, String.valueOf(result));
                    mulMatcher.appendTail(sb);
                    input = sb.toString();
                } else
                    break;
            }
        }
        System.out.println(input);
    }
}
