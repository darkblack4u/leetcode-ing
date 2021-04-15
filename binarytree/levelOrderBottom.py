'''
107. 二叉树的层序遍历 II
给定一个二叉树，返回其节点值自底向上的层序遍历。 （即按从叶子节点所在层到根节点所在的层，逐层从左向右遍历）

例如：
给定二叉树 [3,9,20,null,null,15,7],

    3
   / \
  9  20
    /  \
   15   7
返回其自底向上的层序遍历为：

[
  [15,7],
  [9,20],
  [3]
]
'''
# Definition for a binary tree node.
class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right
class Solution:
    def levelOrderBottom(self, root: TreeNode) -> List[List[int]]:
        ret, stack = [], []
        cur = root
        level = 0
        while stack or cur:
            if cur:
                if len(ret) == level:
                    ret.append([cur.val])
                else:
                    ret[level].append(cur.val)
                stack.append((cur, level))
                cur = cur.left
                level += 1
            else:
                cur, level = stack.pop()
                cur = cur.right
                level += 1
        return ret[: :-1]
