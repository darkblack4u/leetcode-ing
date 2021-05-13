// 33. 搜索旋转排序数组
// 整数数组 nums 按升序排列，数组中的值 互不相同 。

// 在传递给函数之前，nums 在预先未知的某个下标 k（0 <= k < nums.length）上进行了 旋转，使数组变为 [nums[k], nums[k+1], ..., nums[n-1], nums[0], nums[1], ..., nums[k-1]]（下标 从 0 开始 计数）。例如， [0,1,2,4,5,6,7] 在下标 3 处经旋转后可能变为 [4,5,6,7,0,1,2] 。

// 给你 旋转后 的数组 nums 和一个整数 target ，如果 nums 中存在这个目标值 target ，则返回它的下标，否则返回 -1 。

 

// 示例 1：

// 输入：nums = [4,5,6,7,0,1,2], target = 0
// 输出：4
// 示例 2：

// 输入：nums = [4,5,6,7,0,1,2], target = 3
// 输出：-1
// 示例 3：

// 输入：nums = [1], target = 0
// 输出：-1

class Solution {
    public int search(int[] nums, int target) {
        if(nums.length == 1){
            if(nums[0] == target){
                return 0;
            }else{
                return -1;
            }
        }
        int start = 0;
        int end = nums.length - 1;
        while(start < end){
            int middle = (start + end) / 2;
            if(nums[start] == target) return start;
            if(nums[end] == target) return end;
            if(nums[middle] == target) return middle;
            if(nums[middle] > nums[start]){
                if(nums[middle] > target && nums[start] < target){
                    start = start + 1;
                    end = middle - 1;
                }else{
                    start = middle + 1;
                    end = end - 1;
                }
            }else{
                if(nums[middle] < target && nums[end] > target){
                    start = middle + 1;
                    end = end - 1;
                }else{
                    start = start + 1;
                    end = middle - 1;
                }
            }
        }
        return nums[start]==target? start : -1;
    }
}