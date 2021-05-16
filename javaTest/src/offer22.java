import java.util.Scanner;

public class offer22 {
    /**
     * 剑指 Offer 22. 链表中倒数第k个节点
     * https://leetcode-cn.com/problems/lian-biao-zhong-dao-shu-di-kge-jie-dian-lcof/
     * 
     * @param strings
     */
    public static void main(String[] strings) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        ListNode head = null;
        ListNode point = null;
        for (int i = 0; i < n; i++) {
            int num = sc.nextInt();
            ListNode tmp = new ListNode(num);
            if (head == null) {
                head = tmp;
                point = head;
            } else {
                point.next = tmp;
                point = point.next;
            }
        }
        sc.close();
        ListNode ret = getKthFromEnd(head, k);
        StringBuilder sb = new StringBuilder();
        while (ret != null) {
            sb.append(ret.val);
            sb.append("->");
            ret = ret.next;
        }
        System.out.println(sb.toString());
    }

    public static ListNode getKthFromEnd(ListNode head, int k) {
        ListNode point = head;
        ListNode kpoint = head;
        int count = 0;
        while (point != null) {
            if (count >= k) {
                kpoint = kpoint.next;
            }
            point = point.next;
            count++;
        }
        return count >= k ? kpoint : null;
    }
}
