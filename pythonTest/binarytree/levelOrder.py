'''
102. 二叉树的层序遍历
给你一个二叉树，请你返回其按 层序遍历 得到的节点值。 （即逐层地，从左到右访问所有节点）。

示例：
二叉树：[3,9,20,null,null,15,7],

    3
   / \
  9  20
    /  \
   15   7
返回其层序遍历结果：

[
  [3],
  [9,20],
  [15,7]
]
'''
# Definition for a binary tree node.
class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right

class Solution:
    # 迭代方法
    # 执行用时：36 ms, 在所有 Python3 提交中击败了90.77%的用户
    # 内存消耗：14.9 MB, 在所有 Python3 提交中击败了98.46%的用户
    def levelOrder(self, root: TreeNode) -> List[List[int]]:
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
        return ret