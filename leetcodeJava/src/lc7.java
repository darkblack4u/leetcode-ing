public class lc7 {
    /**
     * 7. 整数反转 https://leetcode-cn.com/problems/reverse-integer/
     * 
     * 给你一个 32 位的有符号整数 x ，返回将 x 中的数字部分反转后的结果。
     * 
     * 如果反转后整数超过 32 位的有符号整数的范围 [−231,  231 − 1] ，就返回 0。
     * 
     * 假设环境不允许存储 64 位整数（有符号或无符号）。
     * 
     * @param x
     * @return
     */
    public int reverse(int x) {
        StringBuilder sb = new StringBuilder();
        String s = String.valueOf(x);
        int symbol = 1;
        if (x < 0) {
            sb.append(s.substring(1));
            symbol = -1;
        } else {
            sb.append(s);
        }
        return symbol * Integer.valueOf(sb.reverse().toString());
    }
}
