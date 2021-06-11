import java.util.*;

public class lc113offer34 {
    List<List<Integer>> ret = new ArrayList<>();
    ArrayList<Integer> record = new ArrayList<Integer>();

    /**
     * 剑指 Offer 34. 二叉树中和为某一值的路径
     * https://leetcode-cn.com/problems/er-cha-shu-zhong-he-wei-mou-yi-zhi-de-lu-jing-lcof/
     * https://leetcode-cn.com/problems/path-sum-ii/
     * 
     * 输入一棵二叉树和一个整数，打印出二叉树中节点值的和为输入整数的所有路径。从树的根节点开始往下一直到叶节点所经过的节点形成一条路径。
     * 
     * @param root
     * @param target
     * @return
     */
    public List<List<Integer>> pathSum(TreeNode root, int target) {
        if (root == null) {
            return ret;
        }
        int sum = 0;
        record.add(root.val);
        sum += root.val;
        traceback(root, sum, target);
        return ret;
    }

    public void traceback(TreeNode root, int sum, int target) {
        if (sum == target && root.left == null && root.right == null) {
            ret.add(new ArrayList(record));
            return;
        }
        if (root.left != null) {
            record.add(root.left.val);
            sum = sum + root.left.val;
            traceback(root.left, sum, target);
            sum = sum - root.left.val;
            record.remove(record.size() - 1);
        }
        if (root.right != null) {
            record.add(root.right.val);
            sum = sum + root.right.val;
            traceback(root.right, sum, target);
            sum = sum - root.right.val;
            record.remove(record.size() - 1);
        }
    }
}
