public class lc88nc22 {
    /**
     * 88. 合并两个有序数组 https://leetcode-cn.com/problems/merge-sorted-array/
     * https://www.nowcoder.com/practice/89865d4375634fc484f3a24b7fe65665?tpId=191&tags=&title=&difficulty=0&judgeStatus=0&rp=1
     * 
     * @param nums1
     * @param m
     * @param nums2
     * @param n
     */
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int index_A = m - 1;
        int index_B = n - 1;
        for (int index = m + n - 1; index_A >= 0 && index_B >= 0; index--) {
            if (nums1[index_A] > nums2[index_B]) {
                nums1[index] = nums1[index_A--];
            } else {
                nums1[index] = nums2[index_B--];
            }
        }
        while (index_B >= 0) {
            nums1[index_B] = nums2[index_B--];
        }
    }
}
