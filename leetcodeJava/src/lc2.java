public class lc2 {
    /**
     * 2. 两数相加https://leetcode-cn.com/problems/add-two-numbers/
     * 
     * 给你两个 非空 的链表，表示两个非负的整数。它们每位数字都是按照 逆序 的方式存储的，并且每个节点只能存储 一位 数字。
     * 你将两个数相加，并以相同形式返回一个表示和的链表。
     * 你可以假设除了数字 0 之外，这两个数都不会以 0 开头。
     */
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        }
        if (l2 == null) {
            return l1;
        }
        int number = l1.val + l2.val;
        int value = number % 10;
        int carry = number / 10;
        ListNode result = new ListNode(value);
        ListNode preNode = result;
        ListNode newNode = null;
        l1 = l1.next;
        l2 = l2.next;
        while (l1 != null || l2 != null || carry > 0) {
            if (l1 == null && l2 == null)
                number = carry;
            else if (l1 == null)
                number = carry + l2.val;
            else if (l2 == null)
                number = carry + l1.val;
            else
                number = carry + l1.val + l2.val;
            value = number % 10;
            carry = number / 10;
            newNode = new ListNode(value);
            preNode.next = newNode;
            preNode = newNode;
            if (l2 != null)
                l2 = l2.next;
            if (l1 != null)
                l1 = l1.next;
        }
        return result;
    }
}
