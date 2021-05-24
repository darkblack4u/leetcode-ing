import java.util.*;

public class offer06 {
    /**
     * 剑指 Offer 06. 从尾到头打印链表
     * https://leetcode-cn.com/problems/cong-wei-dao-tou-da-yin-lian-biao-lcof/
     * 
     * @param head
     * @return
     */
    public int[] reversePrint(ListNode head) {
        List<Integer> list = new ArrayList<>();
        while (head != null) {
            list.add(head.val);
            head = head.next;
        }
        int[] res = new int[list.size()];
        for (int i = res.length - 1; i >= 0; i--)
            res[res.length - 1 - i] = list.get(i);
        return res;
    }
}
