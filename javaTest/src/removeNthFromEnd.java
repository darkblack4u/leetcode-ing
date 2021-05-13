/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode currentNode= head;
        ListNode preNode = null;
        ListNode kthNode= null;
        int i = 0;
        while(currentNode != null){
            if(i == n - 1){
                kthNode = head;
            }else if(i > n - 1){
                preNode = kthNode;
                kthNode = kthNode.next;
            }
            currentNode = currentNode.next;
            i++;
        }
        if(kthNode == head){
            return kthNode.next;
        }
        if(kthNode != null && preNode != null){
            preNode.next = kthNode.next;
        }
        return head;
    }
}