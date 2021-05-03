# Definition for a binary tree node.
class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right

class Solution:
    # 迭代
    # 执行用时：32 ms, 在所有 Python3 提交中击败了98.64%的用户
    # 内存消耗：15 MB, 在所有 Python3 提交中击败了44.87%的用户
    def isSymmetric(self, root: TreeNode) -> bool:
        result = True
        leftList = []
        rightList = []
        if root.left != None or root.right != None:
            leftList.append(root.left)
            rightList.append(root.right)
        while leftList or rightList :
            left = leftList.pop()
            right = rightList.pop()
            if left == None: return False
            elif right == None: return False
            elif left.val != right.val: 
                return False
            else:
                if left.left != None or right.right != None:
                    leftList.append(left.left)
                    rightList.append(right.right)
                if left.right != None or right.left != None:
                    leftList.append(left.right)
                    rightList.append(right.left)
        return result


# class Solution:
#     # 递归
#     # 执行用时：56 ms, 在所有 Python3 提交中击败了7.29%的用户
#     # 内存消耗：15 MB, 在所有 Python3 提交中击败了56.19%的用户
#     def isSubSymmetric(self, left: TreeNode, right: TreeNode) -> bool:
#         if left == None and right == None: return True
#         elif left == None: return False
#         elif right == None: return False
#         elif left.val != right.val: return False
#         else:
#             return self.isSubSymmetric(left.left, right.right) and self.isSubSymmetric(left.right, right.left)

#     def isSymmetric(self, root: TreeNode) -> bool:
#         return self.isSubSymmetric(root.left, root.right)