import java.util.Random;

public class lc470 {
    /**
     * 470. 用 Rand7() 实现 Rand10()
     * 
     * 已有方法 rand7 可生成 1 到 7 范围内的均匀随机整数，试写一个方法 rand10 生成 1 到 10 范围内的均匀随机整数。
     * 
     * 不要使用系统的 Math.random() 方法。
     * 
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/implement-rand10-using-rand7
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     * 
     * @return
     */
    public static int rand10() {
        int row, col, ret;
        do {
            row = rand7();
            col = rand7();
            ret = (row - 1) * 7 + col;
        } while (ret > 40);
        return 1 + ret % 10;
    }

    public static int rand7() {
        return new Random().nextInt(6) + 1;
    }

    public static void main(String[] args) {
        System.out.println(rand10());
    }
}
