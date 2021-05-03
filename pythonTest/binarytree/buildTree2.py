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
    def buildTree(self, inorder: List[int], postorder: List[int]) -> TreeNode:
        if len(postorder) == 0:
            return None
        elif len(postorder) == 1:
            return TreeNode(postorder[0])
        else:
            root = postorder[-1]
            index = inorder.index(root)
            if index == 0:
                return TreeNode(root, None, self.buildTree(inorder[1: len(postorder)], postorder[:len(postorder) - 1]))
            elif index == len(inorder) - 1:
                return TreeNode(root, self.buildTree(inorder[0: len(postorder) - 1], postorder[:len(postorder) - 1]), None)
            else:
                postorder_left = postorder[0:index]
                postorder_right = postorder[index: len(postorder) - 1]
                inorder_left = inorder[0:index]
                inorder_right = inorder[index + 1: len(inorder)]
                return TreeNode(root, self.buildTree(inorder_left, postorder_left), self.buildTree(inorder_right, postorder_right))