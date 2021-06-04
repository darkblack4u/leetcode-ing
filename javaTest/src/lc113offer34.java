import java.util.*;

public class lc113offer34 {
    List<List<Integer>> ret = new ArrayList<>();
    ArrayList<Integer> record = new ArrayList<Integer>();

    public List<List<Integer>> pathSum(TreeNode root, int target) {
        if (root == null) {
            return ret;
        }
        int sum = 0;
        record.add(root.val);
        sum += root.val;
        traceback(root, sum, target);
        return ret;
    }

    public void traceback(TreeNode root, int sum, int target) {
        if (sum == target && root.left == null && root.right == null) {
            ret.add(new ArrayList(record));
            return;
        }
        if (root.left != null) {
            record.add(root.left.val);
            sum = sum + root.left.val;
            traceback(root.left, sum, target);
            sum = sum - root.left.val;
            record.remove(record.size() - 1);
        }
        if (root.right != null) {
            record.add(root.right.val);
            sum = sum + root.right.val;
            traceback(root.right, sum, target);
            sum = sum - root.right.val;
            record.remove(record.size() - 1);
        }
    }
}
