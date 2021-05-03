"""
459. 重复的子字符串
给定一个非空的字符串，判断它是否可以由它的一个子串重复多次构成。给定的字符串只含有小写英文字母，并且长度不超过10000。
"""

# class Solution:
#       KMP
#     def repeatedSubstringPattern(self, s: str) -> bool:
#         next = [0] * len(s)
#         next[0] = -1
#         j, k = 0, -1
#         while j < len(s):
#             if k == -1 or s[j] == s[k]:
#                 j += 1
#                 k += 1
#                 next[j] = k
#             else:
#                 k = next[k] # k就是指针，指在前k个与尾部相同那里，k=next[k]的意思可以理解为后续匹配忽略掉前K项中已确认相同部分，j不变对比跟前n项，画图一看便知道了
        


class Solution:
    def repeatedSubstringPattern(self, s: str) -> bool:
        return (s + s)[1: len(s) * 2 - 1].find(s) != -1
        # return (s + s)[1:len(s) * 2 - 1].count(s) != 0
        # return s in (s + s)[1: len(s)*2 -1]

# class Solution:
#     """
#     暴力解法
#     # 执行用时： 88 ms  , 在所有 Python3 提交中击败了 5% 的用户
#     # 内存消耗： 14.9 MB , 在所有 Python3 提交中击败了 29.27% 的用户
#     """
#     def repeatedSubstringPattern(self, s: str) -> bool:
        # pos = 0
        # width = 1
        # i = 1
        # length = len(s)
        # if length == 1: return False
        # mid = length / 2
        # while i < length:
        #     # print(width,pos,i)
        #     if s[i] == s[pos]:
        #         pos += 1
        #         i += 1
        #     else:
        #         i = i - pos + 1
        #         width = i
        #         pos = 0
        #         if width > mid: return False
        #     # if pos == width:
        #     #     pos = 0
        # return width != len(s) and length % width == 0
        