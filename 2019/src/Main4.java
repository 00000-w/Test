import java.util.Scanner;

public class Main4 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        if (n >= 10000) {
            System.out.println("数过大");
            return;
        }
        int t = scanner.nextInt();
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            int m  = scanner.nextInt();
            if (Math.abs(m) > 100000) {
                System.out.println("超过100000");
                return;
            }
            nums[i] = m;
        }
        int success = 0;
        for (int i = 0; i < n - 2; i++) {
            for (int j = i + 1; j < n - 1; j++) {
                for (int k = j + 1; k < n; k++) {
                    if (nums[i] + nums[j] + nums[k] == t) {
                        success++;
                        System.out.println((i + 1) + " " + (j + 1) + " " + (k + 1));
                        if (success == 1)
                            return;
                    }
                }
            }
        }
        System.out.println("-1");
        /*Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        if (n >= 10000) {
            System.out.println("数值过大");
            return;
        }

        int t = scanner.nextInt();
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = scanner.nextInt();
        }
        List<List<Integer>> list = new ArrayList<>();
        for (int i = 0; i < n - 2; i++) {
            for (int j = i + 1; j < n - 1; j++) {
                for (int k = j + 1; k < n; k++) {
                    if (nums[i] + nums[j] + nums[k] == t) {
                        list.add(new ArrayList<>(Arrays.asList(i, j, k)));
                    }
                }
            }
        }
        if (list.isEmpty()) {
            System.out.println("-1");
            return;
        }
        List<Integer> newList = list.get(0);
        System.out.println((newList.get(0) + 1) + " " + (newList.get(1) + 1) + " " + (newList.get(2) + 1));*/
    }
}

