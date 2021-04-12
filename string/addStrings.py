"""
# 给定两个字符串形式的非负整数 num1 和num2 ，计算它们的和。
# 提示：

# num1 和num2 的长度都小于 5100
# num1 和num2 都只包含数字 0-9
# num1 和num2 都不包含任何前导零
# 你不能使用任何內建 BigInteger 库， 也不能直接将输入的字符串转换为整数形式

# 来源：力扣（LeetCode）
# 链接：https://leetcode-cn.com/problems/add-strings
"""


class Solution:
# 执行用时：48 ms, 在所有 Python3 提交中击败了84.84%的用户
# 内存消耗：15 MB, 在所有 Python3 提交中击败了42.32%的用户
    def addStrings(self, num1: str, num2: str) -> str:
        bias = 0
        len1 = len(num1)
        len2 = len(num2)
        out = ''
        cha = max(len1, len2) - min(len1,len2)
        for i in range(min(len1, len2)):
            bias, a = divmod(int(num1[len1 - i - 1]) + int(num2[len2 - i - 1]) + bias, 10)
            out = str(a) + out
        if bias == 0:
            if len1 > len2:
                out = num1[0:len1-len2] + out
            else:
                out = num2[0:len2-len1] + out
        else:
            if len1 > len2:
                for i in range(cha):
                    bias, a = divmod(int(num1[cha - i - 1]) + bias, 10)
                    out = str(a) + out
                    if bias == 0: 
                        out = num1[0:cha - i - 1] + out
                        break
            elif len2 > len1:
                for i in range(cha):
                    bias, a = divmod(int(num2[cha - i - 1]) + bias, 10)
                    out = str(a) + out
                    if bias == 0: 
                        out = num2[0:cha - i - 1] + out
                        break
            if bias == 1:
                out = "1" + out
        return out


# class Solution:
# # 执行用时：72 ms, 在所有 Python3 提交中击败了12.22%的用户
# # 内存消耗：15.1 MB, 在所有 Python3 提交中击败了12.39%的用户
#     def addStrings(self, num1: str, num2: str) -> str:
#         bias = 0
#         len1 = len(num1)
#         len2 = len(num2)
#         out = ''
#         cha = max(len1, len2) - min(len1,len2)
#         for i in range(min(len1, len2)):
#             a = int(num1[len1 - i - 1]) + int(num2[len2 - i - 1]) + bias
#             if a > 9: 
#                 bias = 1
#                 out = str(a)[-1] + out
#             else: 
#                 bias = 0
#                 out = str(a) + out
#         if bias == 0:
#             if len1 > len2:
#                 out = num1[0:len1-len2] + out
#             else:
#                 out = num2[0:len2-len1] + out
#         else:
#             if len1 > len2:
#                 for i in range(cha):
#                     a = int(num1[cha - i - 1]) + bias
#                     if a > 9: 
#                         bias = 1
#                         out = str(a)[-1] + out
#                     else: 
#                         bias = 0
#                         out = num1[0:cha - i - 1] + str(a) + out
#                         break
#             elif len2 > len1:
#                 for i in range(cha):
#                     a = int(num2[cha - i - 1]) + bias
#                     if a > 9: 
#                         bias = 1
#                         out = str(a)[-1] + out
#                     else: 
#                         bias = 0
#                         out = num2[0:cha - i - 1] + str(a) + out
#                         break
#             if bias == 1:
#                 out = "1" + out
#         return out