import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main4 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int k = scanner.nextInt();
        if (k < 0)
            return;
        List<Character> type = new ArrayList<>();
        List<Character> color = new ArrayList<>();
        List<Character> vaccine = new ArrayList<>();
        List<Character> result = new ArrayList<>();
        List<Integer> time = new ArrayList<>();
        scanner.nextLine();
        for (int i = 0; i < k; i++) {
            String str = scanner.nextLine();
            String[] split = str.trim().split("\\s+");
            type.add(split[0].charAt(0));
            color.add(split[1].charAt(0));
            vaccine.add(split[2].charAt(0));
            result.add(split[3].charAt(0));
            time.add(Integer.parseInt(split[4]));
        }
        int sum = 0;
        for (int i = 0; i < k; i++) {
            boolean isType = type.get(i) == 'L';
            boolean isColor = color.get(i) == 'G';
            boolean isVaccine = vaccine.get(i) == 'C';

            boolean isType2 = type.get(i) == 'T';
            boolean isResult = result.get(i) == 'N';
            boolean isTime = time.get(i) < 2;

            if (isType && isColor && isVaccine) {
                sum += 1;
                continue;
            }
            if (isType2 && isColor && isVaccine && isResult && isTime)
                sum += 1;
        }
        System.out.println(sum);
    }
}
