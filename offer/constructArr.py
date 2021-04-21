'''
剑指 Offer 66. 构建乘积数组
给定一个数组 A[0,1,…,n-1]，请构建一个数组 B[0,1,…,n-1]，其中 B[i] 的值是数组 A 中除了下标 i 以外的元素的积, 即 B[i]=A[0]×A[1]×…×A[i-1]×A[i+1]×…×A[n-1]。不能使用除法。

 

示例:

输入: [1,2,3,4,5]
输出: [120,60,40,30,24]
 

提示：

所有元素乘积之和不会溢出 32 位整数
a.length <= 100000
'''
class Solution:
    def constructArr(self, a: List[int]) -> List[int]:
        if not a: return a
        size = len(a)
        # left = [1] * size
        # right = [1] * size
        left = 1
        right = 1
        ret = [1] * size
        # left[0] = 1
        # right[size - 1] = 1
        for i in range(1, size - 1):
            left = left * a[i - 1]
            right = right * a[size - i]
            ret[i] = ret[i] * left
            ret[size - 1 - i] = ret[size - 1 - i] *  right
        ret[size - 1] = left * a[size - 2]
        ret[0] = right * a[1]
        # ret = []
        # for i in range(0, size):
        #     ret.append(left[i] * right[i])
        return ret

