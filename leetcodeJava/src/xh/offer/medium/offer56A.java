package xh.offer.medium;

public class offer56A {
    public int[] singleNumbers(int[] nums) {
        // 先对所有数字进行一次异或，得到两个出现一次的数字的异或值。
        int ret = 0;
        for (int n : nums) {
            ret ^= n;
        }
        // 在异或结果中找到任意为1的位。
        int div = 1;
        while ((div & ret) == 0) {
            div <<= 1;
        }
        // 根据这一位对所有的数字进行分组。
        // 在每个组内进行异或操作，得到两个数字。
        int a = 0, b = 0;
        for (int n : nums) {
            if ((div & n) != 0) {
                a ^= n;
            } else {
                b ^= n;
            }
        }
        return new int[] { a, b };
    }
}
