class Solution {
    public int[] searchRange(int[] nums, int target) {
        int[] ret = new int[]{-1,-1};
        if(nums.length == 0) return ret;
        if(nums.length == 1){
            if(nums[0] == target){
                ret[0] = 0;
                ret[1] = 0;
                return ret;
            }
            else return ret;
        }
        int start = 0;
        int end = nums.length - 1;
        int index = -1;
        while(start <= end){
            if(target < nums[start] || target > nums[end]) return ret;
            int middle = (start + end) / 2;
            if(nums[start] == target){
                index = start;
                break;
            }
            if(nums[end] == target){
                index = end;
                break;
            }
            if(nums[middle] == target){
                index = middle;
                break;
            }
            if(nums[middle] > target){
                start = start + 1;
                end = middle - 1;
            }else{
                start = middle + 1;
                end = end - 1;
            }
        }
        if(index != -1){
            int s = index;
            int e = index;
            while(s >= 0){
                if(nums[s] != target) {
                    break;
                }else{
                    ret[0] = s;
                }
                s--;
            }
            while(e <= nums.length - 1){
                if(nums[e] != target) {
                    break;
                }else{
                    ret[1] = e;
                }
                e++;
            }
            return ret;
        }else{
            return ret;
        }
    }
}