import java.util.*;

public class offer32C {
    /**
     * 剑指 Offer 32 - III. 从上到下打印二叉树 III
     * https://leetcode-cn.com/problems/cong-shang-dao-xia-da-yin-er-cha-shu-iii-lcof/
     * 
     * @param root
     * @return
     */
    public List<List<Integer>> levelOrder(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        List<List<Integer>> res = new ArrayList<>();
        if (root != null)
            queue.add(root);
        boolean a = true;
        while (!queue.isEmpty()) {
            List<Integer> tmp = new ArrayList<>();
            for (int i = queue.size(); i > 0; i--) {
                TreeNode node = queue.poll();
                tmp.add(node.val);
                if (node.left != null)
                    queue.add(node.left);
                if (node.right != null)
                    queue.add(node.right);
            }
            if (!a) {
                Collections.reverse(tmp);
                a = true;
            } else {
                a = false;
            }
            res.add(tmp);
        }
        return res;
    }
}
