public class offer52nc66 {
    /**
     * 剑指 Offer 52. 两个链表的第一个公共节点
     * https://leetcode-cn.com/problems/liang-ge-lian-biao-de-di-yi-ge-gong-gong-jie-dian-lcof/
     * https://www.nowcoder.com/practice/6ab1d9a29e88450685099d45c9e31e46
     * 
     * @param strings
     */
    public static void main(String[] strings) {

    }

    /**
     * 指针过两次，会在公共节点集合如果没有一样的，就都指null
     * 
     * @param headA
     * @param headB
     * @return
     */
    public static ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode a = headA;
        ListNode b = headB;
        while (a != b) {
            if (a == null) {
                a = headB;
            } else {
                a = a.next;
            }
            if (b == null) {
                b = headA;
            } else {
                b = b.next;
            }
        }
        return a;
    }
}