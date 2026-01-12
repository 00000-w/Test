import java.util.*;

public class Main1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = scanner.nextInt();
        }
        int target = scanner.nextInt();
        find(nums, target);
    }
    public static void find(int[] nums, int target) {
        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < nums.length - 1; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] + nums[j] == target) {
                    int k = Math.abs(i - j);
                    map.put(k, new ArrayList<>(Arrays.asList(i, j)));
                }
            }
        }
        int result = 9;
        for (Map.Entry<Integer, List<Integer>> entry : map.entrySet()) {
            if (result > entry.getKey()) {
                result = entry.getKey();
            }
        }
        for (Map.Entry<Integer, List<Integer>> entry : map.entrySet()) {
            if (result == entry.getKey()) {
                System.out.println(entry.getValue().get(0) + " " + entry.getValue().get(1));
                return;
            }
        }
    }

}
