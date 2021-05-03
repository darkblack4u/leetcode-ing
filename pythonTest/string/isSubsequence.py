"""
392. 判断子序列
给定字符串 s 和 t ，判断 s 是否为 t 的子序列。
字符串的一个子序列是原始字符串删除一些（也可以不删除）字符而不改变剩余字符相对位置形成的新字符串。（例如，"ace"是"abcde"的一个子序列，而"aec"不是）。
进阶：
如果有大量输入的 S，称作 S1, S2, ... , Sk 其中 k >= 10亿，你需要依次检查它们是否为 T 的子序列。在这种情况下，你会怎样改变代码？
"""

class Solution:
    """
    # 执行用时： 28 ms  , 在所有 Python3 提交中击败了 99.17% 的用户
    # 内存消耗： 14.8 MB , 在所有 Python3 提交中击败了 94.66% 的用户
    """
    def isSubsequence(self, s: str, t: str) -> bool:
        lenS = len(s)
        lenT = len(t)
        if lenS > lenT:
            return False
        if lenS == 0:
            return True
        pos = 0
        for i in range(lenT):
            if s[pos] == t[i]:
                pos += 1
            if pos == lenS:
                return True
        return False


# class Solution:
#     """
#     # 执行用时： 44 ms  , 在所有 Python3 提交中击败了 48.14% 的用户
#     # 内存消耗： 14.8 MB , 在所有 Python3 提交中击败了 94.98% 的用户
#     """
#     def isSubsequence(self, s: str, t: str) -> bool:
#         lenS = len(s)
#         lenT = len(t)
#         if lenS > lenT:
#             return False
#         if lenS == 0:
#             return True
#         pos = 0
#         for i in range(lenT):
#             if s[pos] == t[i]:
#                 pos += 1
#             if pos == lenS:
#                 return True
#         return False