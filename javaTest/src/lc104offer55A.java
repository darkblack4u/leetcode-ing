import java.util.LinkedList;
import java.util.Queue;

public class lc104offer55A {
    /**
     * 剑指 Offer 55 - I. 二叉树的深度
     * https://leetcode-cn.com/problems/er-cha-shu-de-shen-du-lcof/
     * 
     * @param root
     * @return
     */
    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int depth = 0;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            int n = queue.size();
            for (int i = 0; i < n; i++) {
                TreeNode treeNode = queue.poll();
                if (treeNode.left != null) {
                    queue.offer(treeNode.left);
                }
                if (treeNode.right != null) {
                    queue.offer(treeNode.right);
                }
            }
            depth++;
        }
        return depth;
    }

    /**
     * 深度优先
     */
    public int maxDepthDFS(TreeNode root) {
        if (root == null)
            return 0;
        return Math.max(maxDepth(root.left), maxDepth(root.right)) + 1;
    }
}
