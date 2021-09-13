package xh.offer.easy;

import xh.*;

public class offer55B {
    public boolean isBalanced(TreeNode root) {
        if (root == null) {
            return true;
        }
        int right = depth(root.left);
        int left = depth(root.right);
        if (left == -1 || right == -1 || Math.abs(right - left) > 1) {
            return false;
        }
        return true;
    }

    public int depth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int right = depth(root.right);
        int left = depth(root.left);
        if (left == -1 || right == -1 || Math.abs(right - left) > 1) {
            return -1;
        }
        return Math.max(right, left) + 1;
    }
}
