package xh.hot100.easy;

public class leetcode136 {
    public static void main(String[] args) {
        System.out.println(Integer.toBinaryString(10));
        System.out.println(Integer.toBinaryString(8));
        System.out.println(Integer.toBinaryString(9 ^ 9));
    }

    public int singleNumber(int[] nums) {
        int single = 0;
        for (int num : nums) {
            single ^= num;
        }
        return single;
    }
}
