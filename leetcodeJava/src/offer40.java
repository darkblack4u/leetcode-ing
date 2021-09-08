import java.util.Arrays;

public class offer40 {
    public static void main(String[] strings) {

    }

    /**
     * 剑指 Offer 40. 最小的k个数
     * 
     * https://leetcode-cn.com/problems/zui-xiao-de-kge-shu-lcof/
     * 
     * 输入整数数组 arr ，找出其中最小的 k 个数。例如，输入4、5、1、6、2、7、3、8这8个数字，则最小的4个数字是1、2、3、4。
     * 
     * @param arr
     * @param k
     * @return
     */
    public int[] getLeastNumbers(int[] arr, int k) {
        Arrays.sort(arr);
        return Arrays.copyOfRange(arr, 0, k);
    }
}
