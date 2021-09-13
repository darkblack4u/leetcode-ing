package xh.offer.easy;

import xh.*;

public class offer22 {
    public ListNode getKthFromEnd(ListNode head, int k) {
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
