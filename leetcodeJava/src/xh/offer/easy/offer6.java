package xh.offer.easy;

import java.util.ArrayList;

import xh.ListNode;

public class offer6 {
    public int[] reversePrint(ListNode head) {
        ArrayList<Integer> list = new ArrayList<>();
        while (head != null) {
            list.add(head.val);
            head = head.next;
        }
        int[] res = new int[list.size()];
        for (int i = 0; i < res.length; i++) {
            res[res.length - 1 - i] = list.get(i);
        }
        return res;
    }
}
