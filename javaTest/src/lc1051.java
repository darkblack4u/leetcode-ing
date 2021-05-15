import java.util.Scanner;

/**
 * 1051. 高度检查器 https://leetcode-cn.com/problems/height-checker/
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
