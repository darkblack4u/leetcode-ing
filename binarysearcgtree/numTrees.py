'''
96. 不同的二叉搜索树
给定一个整数 n，求以 1 ... n 为节点组成的二叉搜索树有多少种？

示例:

输入: 3
输出: 5
解释:
给定 n = 3, 一共有 5 种不同结构的二叉搜索树:

   1         3     3      2      1
    \       /     /      / \      \
     3     2     1      1   3      2
    /     /       \                 \
   2     1         2                 3

'''

class Solution:
    # 执行用时：40 ms, 在所有 Python3 提交中击败了59.04%的用户
    # 内存消耗：14.8 MB, 在所有 Python3 提交中击败了68.25%的用户
    tmp = []
    def subTree(self, n: int) -> int:
        if n == 0:
            return 1
        elif n - 1 < len(self.tmp):
            return self.tmp[n - 1]
        else:
            ret = 0
            for i in range(n):
                ret += self.subTree(i) * self.subTree(n - 1 - i)
            self.tmp.append(ret)
            return ret
    def numTrees(self, n: int) -> int:
        return self.subTree(n)

class Solution:
    # 执行用时：44 ms, 在所有 Python3 提交中击败了29.53%的用户
    # 内存消耗：14.8 MB, 在所有 Python3 提交中击败了68.25%的用户
    tmp = []
    def subTree(self, n: int) -> int:
        if n < len(self.tmp):
            return self.tmp[n]
        elif n == 0:
            self.tmp.append(1)
            return 1
        else:
            ret = 0
            for i in range(n):
                ret += self.subTree(i) * self.subTree(n - 1 - i)
            self.tmp.append(ret)
            return ret
    def numTrees(self, n: int) -> int:
        return self.subTree(n)

class Solution:
    # 官方
    # 执行用时：44 ms, 在所有 Python3 提交中击败了29.53%的用户
    # 内存消耗：14.8 MB, 在所有 Python3 提交中击败了62.8%的用户
    def numTrees(self, n: int) -> int:
        G = [0]*(n+1)
        G[0], G[1] = 1, 1

        for i in range(2, n+1):
            for j in range(1, i+1):
                G[i] += G[j-1] * G[i-j]

        return G[n]

class Solution(object):
    def numTrees(self, n):
        """
        :type n: int
        :rtype: int
        卡塔兰数公式见https://baike.baidu.com/item/catalan/7605685?fr=aladdin
        """
        C = 1
        for i in range(0, n):
            C = C * 2*(2*i+1)/(i+2)
        return int(C)