import java.util.*;

public class lc21offer25 {
    /**
     * 剑指 Offer 25. 合并两个排序的链表
     * 
     * @param strings
     */
    public static void main(String[] strings) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        ListNode l1 = null;
        ListNode l2 = null;
        ListNode tmp = null;
        for (int i = 0; i < n; i++) {
            int num = sc.nextInt();
            ListNode cur = new ListNode(num);
            if (i == 0) {
                l1 = cur;
                tmp = l1;
            } else {
                tmp.next = cur;
                tmp = tmp.next;
            }
        }
        for (int i = 0; i < m; i++) {
            int num = sc.nextInt();
            ListNode cur = new ListNode(num);
            if (i == 0) {
                l2 = cur;
                tmp = l2;
            } else {
                tmp.next = cur;
                tmp = tmp.next;
            }
        }
        sc.close();
        ListNode head = mergeTwoLists(l1, l2);
        while (head != null) {
            System.out.println(head.val);
            head = head.next;
        }
    }

    public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null)
            return l2;
        if (l2 == null)
            return l1;
        ListNode ret = null;
        ListNode tmp = null;
        while (l1 != null && l2 != null) {
            if (l1.val > l2.val) {
                ListNode cur = new ListNode(l2.val);
                if (ret == null) {
                    ret = cur;
                    tmp = ret;
                } else {
                    tmp.next = cur;
                    tmp = tmp.next;
                }
                l2 = l2.next;
            } else {
                ListNode cur = new ListNode(l1.val);
                if (ret == null) {
                    ret = cur;
                    tmp = ret;
                } else {
                    tmp.next = cur;
                    tmp = tmp.next;
                }
                l1 = l1.next;
            }
        }
        if (l1 == null) {
            tmp.next = l2;
        } else if (l2 == null) {
            tmp.next = l1;
        }
        return ret;
    }
}
