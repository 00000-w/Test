import java.util.*;

public class Main2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        scanner.nextLine();
        Map<String, Double> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            String input = scanner.nextLine();
            String[] split = input.split("\\s+");
            if (map.containsKey(split[0])) {
                map.put(split[0], map.get(split[0]) + Double.parseDouble(split[1]) * Double.parseDouble(split[2]));
            } else
                map.put(split[0], Double.parseDouble(split[1]) * Double.parseDouble(split[2]));
        }
        List<Double> list = new ArrayList<>();
        for (Map.Entry<String, Double> entry : map.entrySet()) {
            list.add(entry.getValue());
        }
        list.sort(Comparator.reverseOrder()); //升序naturalOrder
        for (int i = 0; i < list.size(); i++) {
            for (Map.Entry<String, Double> entry : map.entrySet()) {
                if (entry.getValue() == list.get(i))
                    System.out.println(entry.getKey() + " " + String.format("%.2f", entry.getValue()));
                else
                    continue;
            }
        }

        /*Scanner scanner = new Scanner(System.in);
        System.out.println("请输入物资的批次数量");
        int n = scanner.nextInt();
        System.out.println("请输入物资的类别、数量及单价");
        scanner.nextLine();
        Map<String,Double> map = new HashMap();
        for (int i = 0; i < n; i++) {
            String input = scanner.nextLine();
            String[] split = input.split("\\s+");
            if (!map.containsKey(split[0])) {
                map.put(split[0], Double.parseDouble(split[1]) * Double.parseDouble(split[2]));
            } else {
                map.put(split[0], map.get(split[0]) + Double.parseDouble(split[1]) * Double.parseDouble(split[2]));
            }
        }
        int i = 0;
        for (Map.Entry<String, Double> entry : map.entrySet()) {
            i++;
        }
        Double[] nums = new Double[i];
        int m = 0;
        for (Map.Entry<String, Double> entry : map.entrySet()) {
            nums[m] = entry.getValue();
            m++;
        }
        Arrays.sort(nums, Collections.reverseOrder());
        for (int j = 0; j < nums.length; j++) {
            for (Map.Entry<String, Double> entry : map.entrySet()) {
                if (entry.getValue() == nums[j])
                    System.out.println(entry.getKey() + " " + nums[j]);
                else
                    continue;
            }
        }*/
    }
}
