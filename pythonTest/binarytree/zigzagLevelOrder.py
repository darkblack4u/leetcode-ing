'''
103. 二叉树的锯齿形层序遍历
给定一个二叉树，返回其节点值的锯齿形层序遍历。（即先从左往右，再从右往左进行下一层遍历，以此类推，层与层之间交替进行）。

例如：
给定二叉树 [3,9,20,null,null,15,7],

    3
   / \
  9  20
    /  \
   15   7
返回锯齿形层序遍历如下：

[
  [3],
  [20,9],
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
    # 执行用时：48 ms, 在所有 Python3 提交中击败了18.78%的用户
    # 内存消耗：14.9 MB, 在所有 Python3 提交中击败了88.01%的用户
    def zigzagLevelOrder(self, root: TreeNode) -> List[List[int]]:
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
        for i in range(len(ret)):
            if i % 2 == 1:
                ret[level].reverse()
        return ret


# class Solution:
#     # 迭代方法
#     # 执行用时：48 ms, 在所有 Python3 提交中击败了18.78%的用户
#     # 内存消耗：14.9 MB, 在所有 Python3 提交中击败了88.01%的用户
#     def zigzagLevelOrder(self, root: TreeNode) -> List[List[int]]:
#         ret, stack = [], []
#         cur = root
#         level = 0
#         while stack or cur:
#             if cur:
#                 if len(ret) == level:
#                     ret.append([cur.val])
#                 elif level % 2 == 0:
#                     ret[level].append(cur.val)
#                 else:
#                     ret[level].insert(0, cur.val)
#                 stack.append((cur, level))
#                 cur = cur.left
#                 level += 1
#             else:
#                 cur, level = stack.pop()
#                 cur = cur.right
#                 level += 1
#         return ret