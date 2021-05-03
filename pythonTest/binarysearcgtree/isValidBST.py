'''
98. 验证二叉搜索树
给定一个二叉树，判断其是否是一个有效的二叉搜索树。

假设一个二叉搜索树具有如下特征：

节点的左子树只包含小于当前节点的数。
节点的右子树只包含大于当前节点的数。
所有左子树和右子树自身必须也是二叉搜索树。
示例 1:

输入:
    2
   / \
  1   3
输出: true
示例 2:

输入:
    5
   / \
  1   4
     / \
    3   6
输出: false
解释: 输入为: [5,1,4,null,null,3,6]。
     根节点的值为 5 ，但是其右子节点值为 4 。
'''


# Definition for a binary tree node.
class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right
class Solution:
    # 执行用时：52 ms, 在所有 Python3 提交中击败了75.96%的用户
    # 内存消耗：17.2 MB, 在所有 Python3 提交中击败了56.26%的用户
    def subBST(self, node: TreeNode, min: TreeNode, max: TreeNode) -> bool:
        if node == None: return True
        if min != None and node.val <= min.val: return False
        if max != None and node.val >= max.val: return False
        return self.subBST(node.left, min, node) and self.subBST(node.right, node, max)


    def isValidBST(self, root: TreeNode) -> bool:
        return self.subBST(root, None, None)