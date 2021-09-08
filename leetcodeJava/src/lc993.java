import java.util.*;

public class lc993 {
    /**
     * 993. 二叉树的堂兄弟节点 https://leetcode-cn.com/problems/cousins-in-binary-tree/
     * 
     * @param root
     * @param x
     * @param y
     * @return
     */
    public boolean isCousins(TreeNode root, int x, int y) {
        if (root.val == x || root.val == y) {
            return false;
        }
        if (root.left != null && (root.left.val == x || root.left.val == y)) {
            return false;
        }
        if (root.right != null && (root.right.val == x || root.right.val == y)) {
            return false;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            int n = queue.size();
            boolean hasTarget = false;
            for (int i = 0; i < n; i++) {
                boolean sameRoot = false;
                TreeNode cur = queue.poll();
                if (cur.left != null) {
                    queue.add(cur.left);
                    if (cur.left.val == x || cur.left.val == y) {
                        if (hasTarget) {
                            if (sameRoot) {
                                return false;
                            } else {
                                return true;
                            }
                        } else {
                            hasTarget = true;
                            sameRoot = true;
                        }
                    }
                }
                if (cur.right != null) {
                    queue.add(cur.right);
                    if (cur.right.val == x || cur.right.val == y) {
                        if (hasTarget) {
                            if (sameRoot) {
                                return false;
                            } else {
                                return true;
                            }
                        } else {
                            hasTarget = true;
                            sameRoot = true;
                        }
                    }
                }
            }
            if (hasTarget) {
                return false;
            }
        }
        return false;
    }
}
