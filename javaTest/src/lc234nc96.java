public class lc234nc96 {
    /**
     * 回文链表 https://leetcode-cn.com/problems/palindrome-linked-list/
     * 
     * @param head
     * @return
     */
    public boolean isPalindrome(ListNode head) {
        if (head != null && head.next == null)
            return true;// 只有一个节点时 也算回文
        ListNode dummtNode = new ListNode(0);
        dummtNode.next = head;
        ListNode fast = dummtNode, slow = dummtNode, endNode = dummtNode;
        // 找到中间节点
        while (fast != null) {
            endNode = slow;
            slow = slow.next;
            fast = fast.next == null ? null : fast.next.next;
        }
        endNode.next = null;// 断开中间节点
        // 将中间节点之后的节点转向
        ListNode pre = null;
        while (slow != null) {
            ListNode node = slow.next;
            slow.next = pre;
            pre = slow;
            slow = node;
        }
        while (head != null && pre != null) {
            if (head.val != pre.val)
                return false;
            head = head.next;
            pre = pre.next;
        }
        return head == null;
    }

    /**
     * https://www.nowcoder.com/practice/3fed228444e740c8be66232ce8b87c2f
     * 
     * @param head
     * @return
     */
    public boolean isPail(ListNode head) {
        // write code here
        if (head != null && head.next == null)
            return true;// 只有一个节点时 也算回文
        ListNode dummtNode = new ListNode(0);
        dummtNode.next = head;
        ListNode fast = dummtNode, slow = dummtNode, endNode = dummtNode;
        // 找到中间节点
        while (fast != null) {
            endNode = slow;
            slow = slow.next;
            fast = fast.next == null ? null : fast.next.next;
        }
        endNode.next = null;// 断开中间节点
        // 将中间节点之后的节点转向
        ListNode pre = null;
        while (slow != null) {
            ListNode node = slow.next;
            slow.next = pre;
            pre = slow;
            slow = node;
        }
        while (head != null && pre != null) {
            if (head.val != pre.val)
                return false;
            head = head.next;
            pre = pre.next;
        }
        return head == null;
    }
}
