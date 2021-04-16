'''
35. 搜索插入位置
给定一个排序数组和一个目标值，在数组中找到目标值，并返回其索引。如果目标值不存在于数组中，返回它将会被按顺序插入的位置。

你可以假设数组中无重复元素。

示例 1:

输入: [1,3,5,6], 5
输出: 2
示例 2:

输入: [1,3,5,6], 2
输出: 1
示例 3:

输入: [1,3,5,6], 7
输出: 4
示例 4:

输入: [1,3,5,6], 0
输出: 0
'''
class Solution:

    def searchInsert(self, nums: List[int], target: int) -> int:
        start, end = 0, len(nums) - 1
        while start < end:
            pos = int((end - start)/2) + start
            if nums[pos] == target: return pos
            elif nums[pos] < target:
                start = pos + 1
                end = end
            else:
                start = start
                end = pos - 1
        if nums[start] < target: return start + 1
        else: return start

    # # 执行用时：32 ms, 在所有 Python3 提交中击败了95.25%的用户
    # # 内存消耗：15.5 MB, 在所有 Python3 提交中击败了5.05%的用户
    # def searchSub(self, nums: List[int], target: int) -> int:
    #     if len(nums) == 1: 
    #         if nums[0] < target: return 1
    #         else: return 0
    #     else:
    #         whole = len(nums)
    #         half = int(whole/2) - 1
    #         if nums[half] == target:
    #             return half
    #         elif nums[half] > target:
    #             if half == 0:
    #                 return half
    #             else:
    #                 return self.searchSub(nums[:half], target)
    #         else:
    #             if half == whole:
    #                 return whole
    #             else:
    #                 return self.searchSub(nums[half + 1:len(nums)], target) + half + 1
    # def searchInsert(self, nums: List[int], target: int) -> int:
    #     return self.searchSub(nums, target)