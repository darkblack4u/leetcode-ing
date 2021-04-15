'''
105. 从前序与中序遍历序列构造二叉树
根据一棵树的前序遍历与中序遍历构造二叉树。

注意:
你可以假设树中没有重复的元素。

例如，给出

前序遍历 preorder = [3,9,20,15,7]
中序遍历 inorder = [9,3,15,20,7]
返回如下的二叉树：

    3
   / \
  9  20
    /  \
   15   7
'''

# Definition for a binary tree node.
class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right
class Solution:
    # 执行用时：188 ms, 在所有 Python3 提交中击败了40.66%的用户
    # 内存消耗：87.2 MB, 在所有 Python3 提交中击败了17.71%的用户
    def buildTree(self, preorder: List[int], inorder: List[int]) -> TreeNode:
        if len(preorder) == 0:
            return None
        elif len(preorder) == 1:
            return TreeNode(preorder[0])
        else:
            root = preorder[0]
            index = inorder.index(root)
            preorder_left = preorder[1:index + 1]
            preorder_right = preorder[index + 1: len(preorder)]
            inorder_left = inorder[0:index]
            inorder_right = inorder[index + 1: len(preorder)]
           
            return TreeNode(root, self.buildTree(preorder_left, inorder_left), self.buildTree(preorder_right, inorder_right))
