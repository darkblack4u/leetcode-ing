package xh.hot100.easy;

import xh.*;
import java.util.*;

public class leetcode104 {
    public int maxDepth(TreeNode root) {
        return dfs(root);
    }

    public int dfs(TreeNode root) {
        if (root == null)
            return 0;
        return 1 + Math.max(dfs(root.left), dfs(root.right));
    }

    public int bfs(TreeNode root) {
        if (root == null) {
            return 0;
        }
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.offer(root);
        int ans = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            while (size > 0) {
                TreeNode node = queue.poll();
                if (node.left != null) {
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    queue.offer(node.right);
                }
                size--;
            }
            ans++;
        }
        return ans;
    }
}
