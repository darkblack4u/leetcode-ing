package xh.hot100.easy;

import java.util.*;

import xh.TreeNode;

public class leetcode94 {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        Deque<TreeNode> queue = new LinkedList<>();
        while (root != null || !queue.isEmpty()) {
            while (root != null) {
                queue.offer(root);
                root = root.left;
            }
            root = queue.pollLast();
            res.add(root.val);
            root = root.right;
        }
        return res;
    }
}
