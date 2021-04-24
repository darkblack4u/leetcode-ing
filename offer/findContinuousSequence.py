'''
剑指 Offer 57 - II. 和为s的连续正数序列
输入一个正整数 target ，输出所有和为 target 的连续正整数序列（至少含有两个数）。

序列内的数字由小到大排列，不同序列按照首个数字从小到大排列。

 

示例 1：

输入：target = 9
输出：[[2,3,4],[4,5]]
示例 2：

输入：target = 15
输出：[[1,2,3,4,5],[4,5,6],[7,8]]
 

限制：

1 <= target <= 10^5
'''
class Solution:
    def findContinuousSequence(self, target: int) -> List[List[int]]:
        ret = []
        for i in range(int(target / 2), 1, -1):
            isFlag = i % 2
            yu = target % i # 取余
            ti = target // i # 取尚
            ha = i//2 
            if not isFlag:
                if yu == ha and ti >= ha: # 偶数时刚好是一半
                    ret.append(list(range(ti - ha + 1, ti + ha + 1 )))
                continue
            else:
                if yu == 0 and ti > ha:# 奇数时刚好是0
                    ret.append(list(range(ti - ha, ti + ha + 1)))
                continue
        return ret


class Solution:
    def findContinuousSequence(self, target: int) -> List[List[int]]:
        start, end = 1, 2
        ret = []
        while start < end <= int(target/2) + 1:
            tmp = int((start + end) * (end - start + 1) /2)
            if tmp == target:
                ret.append(list(range(start, end + 1)))
                start += 1
            elif tmp < target:
                end += 1
            else:
                start += 1
        return ret
