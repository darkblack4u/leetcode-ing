package xh.hot100.easy;

import xh.*;

public class leetcode226 {
    public TreeNode invertTree(TreeNode root) {
        if (root == null)
            return root;
        TreeNode left = root.left;
        TreeNode right = root.right;
        root.left = invertTree(right);
        root.right = invertTree(left);
        return root;
    }
}
