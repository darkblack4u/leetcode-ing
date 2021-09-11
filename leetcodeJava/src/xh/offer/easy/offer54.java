package xh.offer.easy;

import xh.*;

public class offer54 {
    int res, k;

    public int kthLargest(TreeNode root, int k) {
        this.k = k;
        dfs(root);
        return res;
    }

    void dfs(TreeNode root) {
        if (root == null)
            return;
        dfs(root.right);
        if (k == 0)
            return;
        if (--k == 0)
            res = root.val;
        dfs(root.left);
    }
}
