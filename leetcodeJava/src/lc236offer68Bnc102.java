public class lc236offer68Bnc102 {
    /**
     * 剑指 Offer 68 - II. 二叉树的最近公共祖先
     * https://leetcode-cn.com/problems/er-cha-shu-de-zui-jin-gong-gong-zu-xian-lcof/
     * https://leetcode-cn.com/problems/lowest-common-ancestor-of-a-binary-tree/
     * 
     * @param root
     * @param p
     * @param q
     * @return
     */
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || root == p || root == q)
            return root;
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);
        if (left == null && right == null)
            return null;
        if (left == null)
            return right;
        if (right == null)
            return left;
        return root;
    }

    /**
     * https://www.nowcoder.com/practice/e0cc33a83afe4530bcec46eba3325116
     * 
     * @param root
     * @param o1
     * @param o2
     * @return
     */
    public int lowestCommonAncestor(TreeNode root, int o1, int o2) {
        // write code here
        if (root == null)
            return -1;
        if (root.val == o1 || root.val == o2)
            return root.val;
        int left = lowestCommonAncestor(root.left, o1, o2);
        int right = lowestCommonAncestor(root.right, o1, o2);
        if (left == -1 && right == -1)
            return -1;
        if (left == -1)
            return right;
        if (right == -1)
            return left;
        return root.val;
    }
}
