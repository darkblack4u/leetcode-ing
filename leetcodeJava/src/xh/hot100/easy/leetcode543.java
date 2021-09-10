package xh.hot100.easy;

import xh.TreeNode;

public class leetcode543 {
    int max = 0;

    public int diameterOfBinaryTree(TreeNode root) {
        depth(root);
        return max;
    }

    public int depth(TreeNode root) {
        if (root == null)
            return 0;
        int right = depth(root.right);
        int left = depth(root.left);
        max = Math.max(right + left, max);
        return Math.max(right, left) + 1;
    }
}
