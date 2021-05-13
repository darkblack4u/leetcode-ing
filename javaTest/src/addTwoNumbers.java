class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if(l1 == null){
            return l2;
        }
        if(l2 == null){
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
        while(l1 != null || l2 != null || carry > 0){
            if(l1 == null && l2 == null) number = carry;
            else if(l1 == null) number = carry + l2.val;
            else if(l2 == null) number = carry + l1.val;
            else number = carry + l1.val + l2.val;
            value = number % 10;
            carry = number / 10;
            newNode = new ListNode(value);
            preNode.next = newNode;
            preNode = newNode;
            if(l2 != null) l2 = l2.next;
            if(l1 != null)l1 = l1.next;
        }
        return result;
    }
}