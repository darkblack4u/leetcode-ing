public class lc215 {
    /**
     * 215. 数组中的第K个最大元素
     * 
     * 在未排序的数组中找到第 k 个最大的元素。请注意，你需要找的是数组排序后的第 k 个最大的元素，而不是第 k 个不同的元素。
     * 
     * @param nums
     * @param k
     * @return
     */
    public int findKthLargest(int[] nums, int k) {
        int size = nums.length;
        maxHeap(nums, size);
        for (int i = 1; i < k; i++) {
            swap(nums, 0, size - i);
            maxHeap(nums, size - i);
        }
        return nums[0];
    }

    public void maxHeap(int[] nums, int size) {
        for (int i = size / 2; i >= 0; i--) {
            buildMaxHeap(nums, i, size);
        }
    }

    public void buildMaxHeap(int[] nums, int index, int size) {
        int left = index * 2 + 1;
        int right = index * 2 + 2;
        int max = index;
        if (left < size && nums[max] < nums[left]) {
            max = left;
        }
        if (right < size && nums[max] < nums[right]) {
            max = right;
        }
        if (index != max) {
            swap(nums, index, max);
            buildMaxHeap(nums, max, size);
        }
    }

    public void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
}
