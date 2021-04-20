'''
剑指 Offer 10- II. 青蛙跳台阶问题
一只青蛙一次可以跳上1级台阶，也可以跳上2级台阶。求该青蛙跳上一个 n 级的台阶总共有多少种跳法。

答案需要取模 1e9+7（1000000007），如计算初始结果为：1000000008，请返回 1。

示例 1：

输入：n = 2
输出：2
示例 2：

输入：n = 7
输出：21
示例 3：

输入：n = 0
输出：1
提示：

0 <= n <= 100
'''
class Solution:
    def numWays(self, n: int) -> int:
        a, b = 1, 1
        if n == 0 or n == 1: return 1
        i = 2
        while i <= n:
            ret = a + b
            a = b
            if ret > 1000000007:
                b = ret - 1000000007
            else:
                b = ret
            i += 1
        return b