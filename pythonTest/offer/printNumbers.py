'''
剑指 Offer 17. 打印从1到最大的n位数
输入数字 n，按顺序打印出从 1 到最大的 n 位十进制数。比如输入 3，则打印出 1、2、3 一直到最大的 3 位数 999。

示例 1:

输入: n = 1
输出: [1,2,3,4,5,6,7,8,9]
 

说明：

用返回一个整数列表来代替打印
n 为正整数
'''
class Solution:
    def printNumbers(self, n: int) -> List[int]:
        if n == 0: return [0]
        if n == 1: return [1,2,3,4,5,6,7,8,9]
        ret = List[int]
        ret = self.printNumbers(n - 1)
        pown = 10**(n - 1)
        result = []
        for i in range(1, 10):
            times = i * pown
            result.append(times)
            result.extend([x + times for x in ret])
        ret.extend(result)
        return ret