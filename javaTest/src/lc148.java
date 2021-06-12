public class lc148 {
    /**
     * 148. 排序链表 https://leetcode-cn.com/problems/sort-list/
     * 
     * 给你链表的头结点 head ，请将其按 升序 排列并返回 排序后的链表 。
     * 
     * 进阶：
     * 
     * 你可以在 O(n log n) 时间复杂度和常数级空间复杂度下，对链表进行排序吗？
     * 
     * 来源：力扣（LeetCode） 链接：https://leetcode-cn.com/problems/sort-list
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     * 
     * @param head
     * @return
     */
    public ListNode sortList(ListNode head) {
        if (head == null || head.next == null)
            return head;
        ListNode fast = head.next;
        ListNode slow = head;
        while (fast.next != null && fast.next.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        ListNode tmp = slow.next;
        slow.next = null;
        ListNode right = sortList(tmp);
        ListNode left = sortList(head);
        ListNode h = new ListNode(0);
        ListNode res = h;
        while (left != null && right != null) {
            if (left.val < right.val) {
                h.next = left;
                left = left.next;
            } else {
                h.next = right;
                right = right.next;
            }
            h = h.next;
        }
        h.next = left != null ? left : right;
        return res.next;
    }
}
