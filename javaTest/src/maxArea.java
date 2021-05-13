// 11. 盛最多水的容器
// https://leetcode-cn.com/problems/container-with-most-water/solution/container-with-most-water-shuang-zhi-zhen-fa-yi-do/
class Solution {
    public int maxArea(int[] height) {
        int max = 0;
        int left = 0;
        int right = height.length - 1;
        while(left < right){
            int cap = 0;
            int width = right - left;
            if(height[left] < height[right]){
                cap = width * height[left];
                left ++;
            }else{
                cap = width * height[right];
                right --; 
            }
            max = max > cap? max: cap;
        }
        return max;
    }
}