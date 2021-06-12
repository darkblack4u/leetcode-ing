public class lc25 {
    /**
     * 25. K 个一组翻转链表
     * 
     * 给你一个链表，每 k 个节点一组进行翻转，请你返回翻转后的链表。
     * 
     * k 是一个正整数，它的值小于或等于链表的长度。
     * 
     * 如果节点总数不是 k 的整数倍，那么请将最后剩余的节点保持原有顺序。
     * 
     * 进阶：
     * 
     * 你可以设计一个只使用常数额外空间的算法来解决此问题吗？ 你不能只是单纯的改变节点内部的值，而是需要实际进行节点交换。
     * 
     * 来源：力扣（LeetCode） 链接：https://leetcode-cn.com/problems/reverse-nodes-in-k-group
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     * 
     * @param head
     * @param k
     * @return
     */
    public ListNode reverseKGroup(ListNode head, int k) {
        // nextHead指向链表中除去k个节点之后的头节点
        // 初始指向节点head
        ListNode nextHead = head;
        // 链表中剩余节点个数
        int remainNum = 0;
        while (remainNum < k) {
            // 根据题意如果链表剩余节点个数不足k个
            // 则不需要反转，因此直接返回head
            if (nextHead == null) {
                return head;
            }
            remainNum++;
            nextHead = nextHead.next;
        }

        // 递归反转链表中除去前k个节点的后续节点
        ListNode subList = reverseKGroup(nextHead, k);
        // 反转链表中前k个节点
        ListNode newHead = reverseTopN(head, k);
        // 前k个节点反转后，head指向的节点是反转后的链表中的最后一个节点
        // 因此head指向的节点的后继指针指向subList
        head.next = subList;
        return newHead;
    }

    private ListNode reverseTopN(ListNode head, int n) {
        ListNode prev = null;
        // 当前考察的节点
        ListNode cur = head;
        // num小于n，则表示当前节点需要反转
        for (int num = 0; num < n; num++) {
            // 当前节点的下一个节点
            ListNode next = cur.next;
            // 当前节点的后继指针指向prev
            cur.next = prev;
            // prev指向当前节点
            // 表示其是next节点反转后的前一个节点
            prev = cur;
            // cur指向下一个节点
            // 表示下一个节点是待反转节点
            cur = next;
        }
        return prev;
    }
}
