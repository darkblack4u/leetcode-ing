public class lc912 {
    /**
     * 912. 排序数组
     * 
     * 给你一个整数数组 nums，请你将该数组升序排列。 https://leetcode-cn.com/problems/sort-an-array/
     * 
     * @param nums
     * @return
     */
    public int[] sortArray(int[] nums) {
        // quickSort(nums, 0, nums.length - 1); //快排
        // 堆排
        // int length = nums.length;
        // while (length > 0) {
        // heapSort(nums, length);
        // swap(nums, 0, length - 1);
        // length--;
        // }
        int[] temp = new int[nums.length];
        mergeSort(nums, 0, nums.length - 1, temp);
        return nums;
    }

    private void mergeSort(int[] nums, int left, int right, int[] temp) {
        // 小区间使用插入排序
        if (right - left <= 7) {
            insertionSort(nums, left, right);
            return;
        }

        int mid = left + (right - left) / 2;
        // Java 里有更优的写法，在 left 和 right 都是大整数时，即使溢出，结论依然正确
        // int mid = (left + right) >>> 1;

        mergeSort(nums, left, mid, temp);
        mergeSort(nums, mid + 1, right, temp);
        // 如果数组的这个子区间本身有序，无需合并
        if (nums[mid] <= nums[mid + 1]) {
            return;
        }
        mergeOfTwoSortedArray(nums, left, mid, right, temp);
    }

    /**
     * 对数组 arr 的子区间 [left, right] 使用插入排序
     *
     * @param arr   给定数组
     * @param left  左边界，能取到
     * @param right 右边界，能取到
     */
    private void insertionSort(int[] arr, int left, int right) {
        for (int i = left + 1; i <= right; i++) {
            int temp = arr[i];
            int j = i;
            while (j > left && arr[j - 1] > temp) {
                arr[j] = arr[j - 1];
                j--;
            }
            arr[j] = temp;
        }
    }

    /**
     * 合并两个有序数组：先把值复制到临时数组，再合并回去
     *
     * @param nums
     * @param left
     * @param mid   [left, mid] 有序，[mid + 1, right] 有序
     * @param right
     * @param temp  全局使用的临时数组
     */
    private void mergeOfTwoSortedArray(int[] nums, int left, int mid, int right, int[] temp) {
        System.arraycopy(nums, left, temp, left, right + 1 - left);

        int i = left;
        int j = mid + 1;

        for (int k = left; k <= right; k++) {
            if (i == mid + 1) {
                nums[k] = temp[j];
                j++;
            } else if (j == right + 1) {
                nums[k] = temp[i];
                i++;
            } else if (temp[i] <= temp[j]) {
                // 注意写成 < 就丢失了稳定性（相同元素原来靠前的排序以后依然靠前）
                nums[k] = temp[i];
                i++;
            } else {
                // temp[i] > temp[j]
                nums[k] = temp[j];
                j++;
            }
        }
    }

    /**
     * 堆排
     * 
     * @param nums
     * @param length
     */
    public void heapSort(int[] nums, int length) {
        int index = length / 2;
        while (index >= 0) {
            buildHeap(nums, index, length);
            index--;
        }
    }

    public void buildHeap(int[] nums, int index, int n) {
        int root = index;
        int left = index * 2 + 1;
        int right = index * 2 + 2;
        if (left < n && nums[left] > nums[root]) {
            root = left;
        }
        if (right < n && nums[right] > nums[root]) {
            root = right;
        }
        if (root != index) {
            swap(nums, root, index);
            // buildHeap(nums, root, n);
        }
    }

    /**
     * 快排
     * 
     * @param nums
     * @param left
     * @param right
     */
    public void quickSort(int[] nums, int left, int right) {
        if (left >= right)
            return;
        int num = nums[right];
        int position1 = left;
        int position2 = left;
        for (; position1 < right; position1++) {
            if (nums[position1] < num) {
                if (position1 != position2) {
                    swap(nums, position1, position2);
                }
                position2++;
            }
        }
        swap(nums, right, position2);
        quickSort(nums, left, position2 - 1);
        quickSort(nums, position2 + 1, right);
    }

    public void swap(int[] nums, int l, int r) {
        int tmp = nums[l];
        nums[l] = nums[r];
        nums[r] = tmp;
    }
}
