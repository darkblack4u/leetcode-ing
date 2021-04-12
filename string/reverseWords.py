"""
151. 翻转字符串里的单词
给定一个字符串，逐个翻转字符串中的每个单词。

说明：

无空格字符构成一个 单词 。
输入字符串可以在前面或者后面包含多余的空格，但是反转后的字符不能包括。
如果两个单词间有多余的空格，将反转后单词间的空格减少到只含一个。
"""

class Solution:
    """
    # 执行用时： 48 ms  , 在所有 Python3 提交中击败了 35% 的用户
    # 内存消耗： 15 MB , 在所有 Python3 提交中击败了 74% 的用户
    """
    def reverseWords(self, s: str) -> str:
        if s == "":
            return  ""
        list_s = s.split(" ")
        isFirst = True
        out = ""
        for word in list_s:
            if word == "":
                continue
            if isFirst: 
                out = word
                isFirst = False
            else:
                out = word + " " + out
        return out
        


class Solution:
    """
    # 执行用时： 60 ms  , 在所有 Python3 提交中击败了 10.7% 的用户
    # 内存消耗： 15 MB , 在所有 Python3 提交中击败了 38.2% 的用户
    """
    def reverseWords(self, s: str) -> str:
        if s == "":
            return  ""
        pos = True
        isFirst = True
        out = ""
        subString = ""
        for i in range(len(s)):
            if s[i] == " " :
                if pos: continue
                else:
                    if isFirst: out = subString
                    else: out = subString + " " + out
                    subString = ""
                    isFirst = False
                pos = True
            else:
                subString = subString + s[i]
                pos = False
        if pos:
            return out
        else:
            if isFirst: 
                return subString 
            else: 
                return subString + " " + out
        

