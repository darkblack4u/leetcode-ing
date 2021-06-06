public class lc110offer55Bnc62 {
    /**
     * 平衡二叉树 https://leetcode-cn.com/problems/ping-heng-er-cha-shu-lcof/
     * https://leetcode-cn.com/problems/balanced-binary-tree/
     * 
     * @param root
     * @return
     */
    public boolean isBalanced(TreeNode root) {
        return depth(root) == -1 ? false : true;
    }

    /**
     * https://www.nowcoder.com/practice/8b3b95850edb4115918ecebdf1b4d222
     * 
     * @param root
     * @return
     */
    public boolean IsBalanced_Solution(TreeNode root) {
        return depth(root) == -1 ? false : true;
    }

    public int depth(TreeNode root) {
        if (root == null)
            return 0;
        int left = depth(root.left);
        if (left == -1)
            return -1;
        int right = depth(root.right);
        if (right == -1)
            return -1;
        int difference = left - right;
        if (difference < -1 || difference > 1)
            return -1;
        else
            return Math.max(left, right) + 1;
    }
}
