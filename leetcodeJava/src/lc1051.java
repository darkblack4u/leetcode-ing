import java.util.Scanner;

/**
 * 1051. 高度检查器 https://leetcode-cn.com/problems/height-checker/
 * 
 * 学校在拍年度纪念照时，一般要求学生按照 非递减 的高度顺序排列。
 * 
 * 请你返回能让所有学生以 非递减 高度排列的最小必要移动人数。
 * 
 * 注意，当一组学生被选中时，他们之间可以以任何可能的方式重新排序，而未被选中的学生应该保持不动。
 * 
 * 来源：力扣（LeetCode） 链接：https://leetcode-cn.com/problems/height-checker
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class lc1051 {
    public static void main(String[] strings) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] heights = new int[n];
        for (int i = 0; i < n; i++) {
            heights[i] = sc.nextInt();
        }
        sc.close();
        System.out.println(heightChecker(heights));
    }

    /**
     * 桶排序，对比有哪些位置不一样的
     * 
     * @param heights
     * @return
     */
    public static int heightChecker(int[] heights) {
        int[] count = new int[101];
        int ret = 0;
        int index = 0;
        for (int i = 0; i < heights.length; i++) {
            count[heights[i]]++;
        }
        for (int i = 0; i < count.length; i++) {
            for (int j = 0; j < count[i]; j++) {
                if (heights[index] != i)
                    ret++;
                index++;
            }
        }
        return ret;
    }
}
