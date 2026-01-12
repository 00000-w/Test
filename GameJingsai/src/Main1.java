import java.util.Scanner;

public class Main1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = scanner.nextInt();
        }
        int target = scanner.nextInt();

        int index1 = -1,index2 = -1;
        int minDiff = Integer.MAX_VALUE;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (nums[j] == target - nums[i]) {
                    if (minDiff > j - i && i != j) {
                        minDiff = j - i;
                        index1 = Math.min(i,j);
                        index2 = Math.max(i,j);
                    }
                }
            }
        }

        if (minDiff != Integer.MAX_VALUE) {
            System.out.println(index1 + " " + index2);
        } else
            System.out.println("NULL");
    }
}
