class Solution {
    public void nextPermutation(int[] nums) {
        if(nums.length == 1) return;
        int tmp = 0;
        int firstPos = nums.length - 1;
        for(int i = nums.length - 2; i >= 0; i--){
            if(nums[i] < nums[i + 1]){
                firstPos = i;
                break;
            }
        }
        if(firstPos != nums.length - 1){
            for(int i = nums.length - 1; i > firstPos; i --){
                if(nums[i] <= nums[firstPos]) continue;
                else{
                    tmp = nums[firstPos];
                    nums[firstPos] = nums[i];
                    nums[i] = tmp;
                    break;
                }
            }
        }
        for(int i = (firstPos + 1) % nums.length, j = nums.length - 1; i < j; i++, j--){
            if(nums[i] > nums[j]){
                tmp = nums[i];
                nums[i] = nums[j];
                nums[j] = tmp;
            }
        }
    }
}