'''
剑指 Offer 25. 合并两个排序的链表
输入两个递增排序的链表，合并这两个链表并使新链表中的节点仍然是递增排序的。

示例1：

输入：1->2->4, 1->3->4
输出：1->1->2->3->4->4
限制：

0 <= 链表长度 <= 1000
'''

# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, x):
#         self.val = x
#         self.next = None

class Solution:
    def mergeTwoLists(self, l1: ListNode, l2: ListNode) -> ListNode:
        if not l2: return l1
        if not l1: return l2
        pos_l1 = l1
        pos_l2 = l2
        ret = None
        if pos_l1.val <= pos_l2.val:
            ret = pos_l1
            pos_l1 = pos_l1.next
        else:
            ret = pos_l2
            pos_l2 = pos_l2.next
        head = ret
        while pos_l1 or pos_l2:
            if pos_l1 == None:
                ret.next = pos_l2
                break
            if pos_l2 == None:
                ret.next = pos_l1
                break
            if pos_l1.val <= pos_l2.val:
                ret.next = pos_l1
                pos_l1 = pos_l1.next
            else:
                ret.next = pos_l2
                pos_l2 = pos_l2.next
            ret = ret.next
        return head
