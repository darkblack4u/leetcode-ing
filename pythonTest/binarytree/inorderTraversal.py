# Definition for a binary tree node.

# 中序遍历 先遍历左子树->根节点->右子树
# 如果是递归做法则递归遍历左子树，访问根节点，递归遍历右子树
# 非递归过程即:先访问..最左子树..结点，再访问其父节点，再访问其兄弟
# while循环条件 中序遍历需先判断当前结点是否存在，若存在则将该节点放入栈中，再将当前结点设置为结点的左孩子，
# 若不存在则取栈顶元素为cur，当且仅当栈空cur也为空，循环结束。
class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right
class Solution:
    # 递归方法
    # 执行用时：32 ms, 在所有 Python3 提交中击败了94.6%的用户
    # 内存消耗：14.8 MB, 在所有 Python3 提交中击败了56.99%的用户
    def inorder(self, node: TreeNode):
        out = []
        if node == None: 
            return []
        else:
            out.extend(self.inorder(node.left))
            out.append(node.val)
            out.extend(self.inorder(node.right))
            return out
            
    def inorderTraversal(self, root: TreeNode) -> List[int]:
        return self.inorder(root)


# class Solution:
#     # 迭代方法
#     # 执行用时：44 ms, 在所有 Python3 提交中击败了32.59%的用户
#     # 内存消耗：15 MB, 在所有 Python3 提交中击败了5.72%的用户
#     def inorderTraversal(self, root: TreeNode) -> List[int]:
#         stack, ret = [], []
#         cur = root
#         while stack or cur:
#             if cur:
#                 stack.append(cur)
#                 cur = cur.left
#             else:
#                 cur = stack.pop()
#                 ret.append(cur.val)
#                 cur = cur.right
#         return ret