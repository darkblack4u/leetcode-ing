public class offer26nc98 {
    /**
     * 剑指 Offer 26. 树的子结构 https://leetcode-cn.com/problems/shu-de-zi-jie-gou-lcof/
     * 
     * @param A
     * @param B
     * @return
     */
    public boolean isSubStructure(TreeNode A, TreeNode B) {
        return (A != null && B != null) && (recur(A, B) || isSubStructure(A.left, B) || isSubStructure(A.right, B));
    }

    boolean recur(TreeNode A, TreeNode B) {
        if (B == null)
            return true;
        if (A == null || A.val != B.val)
            return false;
        return recur(A.left, B.left) && recur(A.right, B.right);
    }

    /**
     * https://www.nowcoder.com/practice/4eaccec5ee8f4fe8a4309463b807a542
     * 
     * @param root1
     * @param root2
     * @return
     */
    public boolean isContains(TreeNode root1, TreeNode root2) {
        if (root1 != null && root2 == null)
            return false;
        if (root2 != null && root1 == null)
            return false;
        if (root2 == null && root1 == null)
            return true;
        // write code here
        if (root1.val == root2.val) {
            return isContains(root1.left, root2.left) && isContains(root1.right, root2.right);
        } else {
            return isContains(root1.left, root2) || isContains(root1.right, root2);
        }
    }
}
