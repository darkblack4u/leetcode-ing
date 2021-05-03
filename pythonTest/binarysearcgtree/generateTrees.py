
'''
95. 不同的二叉搜索树 II
给定一个整数 n，生成所有由 1 ... n 为节点所组成的 二叉搜索树 。

示例：

输入：3
输出：
[
  [1,null,3,2],
  [3,2,null,1],
  [3,1,null,null,2],
  [2,1,3],
  [1,null,2,null,3]
]
解释：
以上的输出对应以下 5 种不同结构的二叉搜索树：

   1         3     3      2      1
    \       /     /      / \      \
     3     2     1      1   3      2
    /     /       \                 \
   2     1         2                 3
'''

# Definition for a binary tree node.
class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right
class Solution:
    # 执行用时：52 ms, 在所有 Python3 提交中击败了89.74%的用户
    # 内存消耗：16.2 MB, 在所有 Python3 提交中击败了86.27%的用户
    def subTree(self, min, max):
        if min > max:
            return [None]
        if min == max:
            return [TreeNode(min)]
        else:
            out = []
            for i in range(min, max + 1):
                left = self.subTree(min, i - 1)
                right = self.subTree(i + 1, max)
                for l in left:
                    for r in right:
                        out.append(TreeNode(i, left=l, right=r))
            return out

    def generateTrees(self, n: int) -> List[TreeNode]:
        return self.subTree(1, n)