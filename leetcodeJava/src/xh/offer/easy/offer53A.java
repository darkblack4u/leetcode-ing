package xh.offer.easy;

public class offer53A {
    public int search(int[] nums, int target) {
        int i = 0;
        int j = nums.length - 1;
        int count = 0;
        while (i <= j) {
            int mid = (i + j) / 2;
            if (nums[mid] < target) {
                i = mid + 1;
            } else if (nums[mid] > target) {
                j = mid - 1;
            } else {
                int index = mid;
                while (index <= j && nums[index] == target) {
                    count++;
                    index++;
                }
                index = mid - 1;
                while (index >= i && nums[index] == target) {
                    count++;
                    index--;
                }
                break;
            }
        }
        return count;
    }
}
