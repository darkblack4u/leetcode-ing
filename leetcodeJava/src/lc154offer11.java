import java.util.Scanner;

public class lc154offer11 {
    /**
     * 剑指 Offer 11. 旋转数组的最小数字
     * https://leetcode-cn.com/problems/xuan-zhuan-shu-zu-de-zui-xiao-shu-zi-lcof/
     * https://leetcode-cn.com/problems/find-minimum-in-rotated-sorted-array-ii/
     * 把一个数组最开始的若干个元素搬到数组的末尾，我们称之为数组的旋转。输入一个递增排序的数组的一个旋转，输出旋转数组的最小元素。例如，数组 [3,4,5,1,2]
     * 为 [1,2,3,4,5] 的一个旋转，该数组的最小值为1。  
     * 
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/xuan-zhuan-shu-zu-de-zui-xiao-shu-zi-lcof
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
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
