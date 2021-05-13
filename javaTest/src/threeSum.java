class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<>();
        for(int first = 0; first < nums.length - 2; first++){
            if(nums[first] > 0){
                break;
            }
            if(first > 0 && nums[first] == nums[first - 1]){
                continue;
            }
            int second = first + 1;
            int third = nums.length - 1;
            while(second < third){
                int sum = nums[first] + nums[third] + nums[second];
                if(sum > 0){
                    while(second < third && nums[third] == nums[--third]);
                }
                if(sum < 0){
                    while(second < third && nums[second] == nums[++second]);
                }
                if(sum == 0){
                    List<Integer> entity = new ArrayList<Integer>(Arrays.asList(nums[first], nums[second], nums[third]));
                    res.add(entity);
                    while(second < third && nums[third] == nums[--third]);
                    while(second < third && nums[second] == nums[++second]);
                }
            }
        }
        return res;
    }
}