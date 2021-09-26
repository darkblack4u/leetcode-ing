package xh.offer.medium;

import xh.*;

import java.util.*;

public class offer34 {
    List<List<Integer>> ret = new ArrayList<>();

    public List<List<Integer>> pathSum(TreeNode root, int target) {
        if (root == null) {
            return ret;
        }
        List<Integer> list = new ArrayList<Integer>();
        int sum = 0;
        traceBack(list, sum, root, target);
        return ret;
    }

    public void traceBack(List<Integer> list, int sum, TreeNode node, int target) {
        int val = node.val;
        sum += val;
        list.add(val);
        if (node.left == null && node.right == null) {
            if (sum == target) {
                List<Integer> retlist = new ArrayList<Integer>();
                for (Integer integer : list) {
                    retlist.add(integer);
                }
                ret.add(retlist);
            }
        } else {
            if (node.left != null)
                traceBack(list, sum, node.left, target);
            if (node.right != null)
                traceBack(list, sum, node.right, target);
        }
        list.remove(list.size() - 1);
    }
}
