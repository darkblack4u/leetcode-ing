import java.util.HashMap;

public class lc781 {
    /**
     * 781. 森林中的兔子
     * 森林中，每个兔子都有颜色。其中一些兔子（可能是全部）告诉你还有多少其他的兔子和自己有相同的颜色。我们将这些回答放在 answers 数组里。
     * 
     * 返回森林中兔子的最少数量。
     * 
     * 来源：力扣（LeetCode） 链接：https://leetcode-cn.com/problems/rabbits-in-forest
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     * 
     * @param answers
     * @return
     */
    public int numRabbits(int[] answers) {
        if (answers.length == 0)
            return 0;
        if (answers.length == 1)
            return answers[0] + 1;
        int ret = 0;
        HashMap<Integer, Integer> hm = new HashMap<>();
        for (int i = 0; i < answers.length; i++) {
            int num = answers[i];
            if (num == 0) {
                ret += 1;
                continue;
            }
            if (hm.getOrDefault(num, 0) == 0) {
                hm.put(num, num);
                ret += (num + 1);
            } else {
                hm.put(num, hm.get(num) - 1);
            }
        }
        return ret;
    }
}
