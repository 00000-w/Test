import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

class ListNode {
    int val;
    ListNode next;

    ListNode(int val) {
        this.val = val;
        this.next = null;
    }
}

public class Main2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        ListNode head = new ListNode(scanner.nextInt());
        ListNode tmp = head;
        for (int i = 0; i < n - 1; i++) {
            ListNode listNode = new ListNode(scanner.nextInt());
            tmp.next = listNode;
            tmp = listNode;
        }

        //遍历计算出现的次数
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(head.val, 1);
        tmp = head.next;
        while (tmp != null) {
            map.merge(tmp.val, 1, Integer::sum);
            tmp = tmp.next;
        }

        //value不为1的进行删除
        tmp = head;
        ListNode tmp2 = tmp.next;
        while (tmp2 != null) {
            int i = 0;
            for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
                if (tmp2.val == entry.getKey() && entry.getValue() > 1) {
                    tmp.next = tmp2.next;
                    i += 1;
                    break;
                }
            }
            if (i == 0) {
                tmp = tmp.next;
            }
            tmp2 = tmp.next;
        }
        
        //检查头部
        ListNode oldHead = head;
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (head.val == entry.getKey() && entry.getValue() > 1) {
                head = head.next;
                oldHead.next = null;
                break;
            }
        }

        //遍历
        tmp = head.next;
        System.out.print(head.val);
        while (tmp != null) {
            System.out.print(" -> " + tmp.val);
            tmp = tmp.next;
        }
    }
}
