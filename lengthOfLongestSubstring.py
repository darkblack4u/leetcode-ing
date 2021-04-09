class Solution:
    def lengthOfLongestSubstring(self, s: str) -> int:
        if s is "":
            return 0
        dictLetter = dict()
        for letter in s:
            if dictLetter.keys