public class lc67 {
    /**
     * 剑指 Offer II 002. 二进制加法
     * 
     * @param a
     * @param b
     * @return
     * 
     *         给你两个二进制字符串，返回它们的和（用二进制表示）。
     * 
     *         输入为 非空 字符串且只包含数字 1 和 0。
     * 
     *         https://leetcode-cn.com/problems/add-binary/
     */
    public String addBinary(String a, String b) {
        /**
         * function by myself
         */
        StringBuilder result = new StringBuilder();
        int i = a.length() - 1;
        int j = b.length() - 1;
        int carry = 0;
        while (i >= 0 || j >= 0) {
            int digitA = i >= 0 ? a.charAt(i--) - '0' : 0;
            int digitB = j >= 0 ? b.charAt(j--) - '0' : 0;
            int sum = digitA + digitB + carry;
            carry = sum >= 2 ? 1 : 0;
            sum = sum >= 2 ? sum - 2 : sum;
            result.append(sum);
        }
        if (carry == 1) {
            result.append(1);
        }
        return result.reverse().toString();
    }
}
