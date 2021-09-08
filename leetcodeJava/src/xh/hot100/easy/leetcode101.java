package xh.hot100.easy;

import java.util.*;

import xh.*;

public class leetcode101 {
    /**
     * 循环
     * 
     * @param root
     * @return
     */
    public boolean isSymmetric(TreeNode root) {
        if (root == null || (root.left == null && root.right == null))
            return true;
        if (root.left == null || root.right == null || root.left.val != root.right.val)
            return false;
        TreeNode left = root.left;
        TreeNode right = root.right;
        LinkedList<TreeNode> layer = new LinkedList<>();
        layer.add(left);
        layer.add(right);
        TreeNode l;
        TreeNode r;
        while (!layer.isEmpty()) {
            int num = layer.size();
            // if (num % 2 == 1) {
            // return false;
            // }
            for (int i = 0; i < num / 2; i++) {
                l = layer.get(i);
                r = layer.get(num - 1 - i);
                if (l.val != r.val)
                    return false;
                if (l.left == null) {
                    if (r.right != null)
                        return false;
                } else {
                    if (r.right == null)
                        return false;
                }
                if (l.right == null) {
                    if (r.left != null) {
                        return false;
                    }
                } else {
                    if (r.left == null) {
                        return false;
                    }
                }
            }
            for (int i = 0; i < num; i++) {
                TreeNode node = layer.removeFirst();
                if (node.left != null) {
                    layer.add(node.left);
                }
                if (node.right != null) {
                    layer.add(node.right);
                }
            }
        }
        return true;
    }

    /**
     * 递归
     * 
     * @param t1
     * @param t2
     * @return
     */
    public boolean isMirror(TreeNode t1, TreeNode t2) {
        if (t1 == null && t2 == null)
            return true;
        if (t1 == null || t2 == null)
            return false;
        return (t1.val == t2.val) && isMirror(t1.right, t2.left) && isMirror(t1.left, t2.right);
    }
}
