import java.util.Scanner;

public class lc154offer11 {
    /**
     * 剑指 Offer 11. 旋转数组的最小数字
     * https://leetcode-cn.com/problems/xuan-zhuan-shu-zu-de-zui-xiao-shu-zi-lcof/
     * https://leetcode-cn.com/problems/find-minimum-in-rotated-sorted-array-ii/
     */
    public static void main(String[] strings) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] numbers = new int[n];
        for (int i = 0; i < n; i++) {
            int num = sc.nextInt();
            numbers[i] = num;
        }
        sc.close();
        System.out.println(minArray(numbers));
    }

    public static int minArray(int[] numbers) {
        int i = 0;
        int j = numbers.length - 1;
        while (i < j) {
            int m = (i + j) / 2;
            if (numbers[m] < numbers[i])
                j = m;
            else if (numbers[m] > numbers[j])
                i = m + 1;
            else
                j--;
        }
        return numbers[i];
    }
}
