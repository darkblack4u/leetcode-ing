public class lc233offer43 {
    /**
     * 233. 数字 1 的个数
     * 
     * 给定一个整数 n，计算所有小于等于 n 的非负整数中数字 1 出现的个数。
     * 
     * @param n
     * @return
     */
    public int countDigitOne(int n) {
        // 0 ~ 9: 1
        // 0 ~ 99: 1 * 10 + 10
        // 0 ~ 999: 1 * 100 + 10 * 10 + 100
        // 0 ~ 9999: 1 * 1000 + 10 * 100 + 100 * 10 + 1000
        //
        // example: 3456 => 3000 + 400 + 50 + 6
        // => 1 * (1000(因为3 > 0))+ 1 * (300 + 100(因为4 > 1))+ 1 * (340 + 10(因为5 > 1)) + 1
        // * (345 + 1 (因为6 >= 1))
        // =>
        int digit = 1, res = 0;
        int high = n / 10, cur = n % 10, low = 0;
        while (high != 0 || cur != 0) {
            if (cur == 0)
                res += high * digit;
            else if (cur == 1)
                res += (high * digit + low + 1);
            else
                res += (high + 1) * digit;
            low += cur * digit;
            cur = high % 10;
            high /= 10;
            digit *= 10;
        }
        return res;
    }
}