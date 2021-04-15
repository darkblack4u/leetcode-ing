'''
538. 把二叉搜索树转换为累加树
给出二叉 搜索 树的根节点，该树的节点值各不相同，请你将其转换为累加树（Greater Sum Tree），使每个节点 node 的新值等于原树中大于或等于 node.val 的值之和。

提醒一下，二叉搜索树满足下列约束条件：

节点的左子树仅包含键 小于 节点键的节点。
节点的右子树仅包含键 大于 节点键的节点。
左右子树也必须是二叉搜索树。
'''

# Definition for a binary tree node.
class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right
class Solution:
    # 执行用时：80 ms, 在所有 Python3 提交中击败了52.24%的用户
    # 内存消耗：17.1 MB, 在所有 Python3 提交中击败了60.67%的用户
    def convertSubBST(self, root: TreeNode, total: int):
        if root == None: 
            return None, total
        root.right, total = self.convertSubBST(root.right, total)
        total = root.val + total
        root.val = total
        root.left, total = self.convertSubBST(root.left, total)
        return root, total
    def convertBST(self, root: TreeNode) -> TreeNode:
        total = 0
        return self.convertSubBST(root, total)[0]
