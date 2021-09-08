import java.util.Scanner;

/**
 * 剑指 Offer 24. 反转链表 https://leetcode-cn.com/problems/fan-zhuan-lian-biao-lcof/
 */
public class offer24 {

    // public class ListNode {
    // int val;
    // ListNode next;

    // ListNode(int x) {
    // val = x;
    // }
    // }

    public static void main(String[] strings) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        ListNode head = null;
        ListNode tmp = null;
        for (int i = 0; i < n; i++) {
            int num = sc.nextInt();
            if (head == null) {
                head = new ListNode(num);
                tmp = head;
            } else {
                tmp.next = new ListNode(num);
                tmp = tmp.next;
            }
        }
        sc.close();
        ListNode ret = reverseList(head);
        StringBuilder sb = new StringBuilder();
        while (ret != null) {
            sb.append(ret.val).append(" ");
            ret = ret.next;
        }
        System.out.println(sb.toString());
    }

    public static ListNode reverseList(ListNode head) {
        ListNode curr = head;
        ListNode prev = null;
        while (curr != null) {
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }
}
