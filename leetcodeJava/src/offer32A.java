import java.util.*;

public class offer32A {
    /**
     * 剑指 Offer 32 - I. 从上到下打印二叉树
     * https://leetcode-cn.com/problems/cong-shang-dao-xia-da-yin-er-cha-shu-lcof/
     * 
     * @param strings
     */
    public static void main(String[] strings) {

    }

    public int[] levelOrder(TreeNode root) {
        if (root == null)
            return new int[0];
        List<Integer> ans = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            int n = queue.size();
            for (int i = 0; i < n; i++) {
                TreeNode treeNode = queue.poll();
                ans.add(treeNode.val);
                if (treeNode.left != null) {
                    queue.add(treeNode.left);
                }
                if (treeNode.right != null) {
                    queue.add(treeNode.right);
                }
            }
        }
        int[] res = new int[ans.size()];
        for (int i = 0; i < ans.size(); i++)
            res[i] = ans.get(i);
        return res;
    }
}
