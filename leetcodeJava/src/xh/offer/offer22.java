package xh.offer;

import xh.ListNode;

public class offer22 {
    public static void main(String[] args) {

    }

    public ListNode getKthFromEnd(ListNode head, int k) {
        ListNode fast = head;
        ListNode slow = head;
        int count = 0;
        while (count < k) {
            fast = fast.next;
            count++;
            if (fast == null)
                return count == k ? slow : null;
        }
        while (fast != null) {
            fast = fast.next;
            slow = slow.next;
        }
        return slow;
    }
}
