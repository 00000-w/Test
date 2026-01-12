import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main4 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String first = scanner.next();
        String second = scanner.next();
        System.out.println(compareCards(first, second));
    }

    public static int compareCards(String firstCards, String secondCards) {
        String oneRegex = "^[1-9ATJQK]$";
        String twoRegex = "^([1-9ATJQK])\\1$";
        String threeRegex = "^([1-9ATJQK])\\1\\1$";

        Pattern pattern1 = Pattern.compile(oneRegex);
        Pattern pattern2 = Pattern.compile(twoRegex);
        Pattern pattern3 = Pattern.compile(threeRegex);

        Matcher matcher11 = pattern1.matcher(firstCards);
        Matcher matcher12 = pattern1.matcher(secondCards);
        Matcher matcher21 = pattern2.matcher(firstCards);
        Matcher matcher22 = pattern2.matcher(secondCards);
        Matcher matcher31 = pattern3.matcher(firstCards);
        Matcher matcher32 = pattern3.matcher(secondCards);

        //单牌比较
        if (matcher11.matches() && matcher12.matches()) {
            return compare(firstCards, secondCards);
        }

        //对子比较
        if (matcher21.matches() && matcher22.matches()) {
            return compare(firstCards, secondCards);
        }

        //炸弹比较
        if (matcher31.matches() && matcher32.matches()) {
            return compare(firstCards, secondCards);
        } else if (matcher31.matches() && (matcher12.matches() || matcher22.matches())) {
            return 1;
        } else if (matcher32.matches() && (matcher11.matches() || matcher21.matches())) {
            return -1;
        }

        return -999;
    }

    public static int change(String s) {
        int sInt = 0;
        if (s.charAt(0) == 'A' || s.equals("1"))
            sInt = 14;
        else if (s.charAt(0) == 'K')
            sInt = 13;
        else if (s.charAt(0) == 'Q')
            sInt = 12;
        else if (s.charAt(0) == 'J')
            sInt = 11;
        else if (s.charAt(0) == 'T')
            sInt = 10;
        else
            sInt = Integer.parseInt(String.valueOf(s.charAt(0)));
        return sInt;
    }

    public static int compare(String firstCards, String secondCards) {
        if (firstCards.length() == 3 && secondCards.length() == 3) {
            int first = change(firstCards);
            int second = change(secondCards);
            if (first == 2)
                first = 99;
            if (first == second)
                return 0;
            if (first > second)
                return 1;
            return -1;
        }

        int num1 = change(firstCards);
        int num2 = change(secondCards);
        if (!(num1 == 2) && !(num2 == 2)) {
            int result = num1 - num2;
            if (result == -1)
                return -1;
            else if (result == 1)
                return 1;
            else if (result == 0)
                return 0;
            else
                return 2;
        } else if (num1 == 2 && num2 == 2) {
            return 0;
        } else if (num1 == 2)
            return 1;
        else
            return -1;
    }
}
