# Longest Substring Without Repeating Characters
# Given a string s, find the length of the longest substring without repeating characters.

# https://leetcode-cn.com/problems/longest-substring-without-repeating-characters/

class Solution:
    """
    # 执行用时： 88 ms  , 在所有 Python3 提交中击败了 40.53% 的用户
    # 内存消耗： 14.9 MB , 在所有 Python3 提交中击败了 29.27% 的用户
    """
    def lengthOfLongestSubstring(self, s: str) -> int:
        st = {}
        pos, ans = 0, 0
        for j in range(len(s)):
            if s[j] in st:
                pos = max(st[s[j]], pos)   # pos要保持指在最近的一个不重复的点那里
            ans = max(ans, j - pos + 1)    # 每次都要更新到pos的距离
            st[s[j]] = j + 1               # 最后一次出现sj的位置
        return ans


# class Solution:
#     # 执行用时： 760 ms  , 在所有 Python3 提交中击败了 7.57% 的用户
#     # 内存消耗： 15 MB , 在所有 Python3 提交中击败了 29.27% 的用户
#     def lengthOfLongestSubstring(self, s: str) -> int:
#         if s is "":
#             return 0
#         dictLetter = dict()
#         maxLength = 0
#         for letter in s:
#             if letter in dictLetter.keys():
#                 if dictLetter[letter] == 0:
#                     for letterKey in dictLetter.keys():
#                         if dictLetter[letterKey] != 0:
#                             dictLetter[letterKey] += 1
#                 else:
#                     for letterKey in dictLetter.keys():
#                         if dictLetter[letterKey] == dictLetter[letter]:
#                             maxLength = max(dictLetter[letterKey], maxLength)
#                         elif dictLetter[letterKey] > dictLetter[letter]:
#                             maxLength = max(dictLetter[letterKey], maxLength)
#                             dictLetter[letterKey] = 0
#                         elif dictLetter[letterKey] != 0:
#                             dictLetter[letterKey] += 1
#                 dictLetter[letter] = 1
#             else:
#                 for letterKey in dictLetter.keys():
#                     if dictLetter[letterKey] != 0:
#                         dictLetter[letterKey] += 1
#                 dictLetter[letter] = 1
#         for letterKey in dictLetter.keys():
#             maxLength = max(dictLetter[letterKey], maxLength)
#         return maxLength
