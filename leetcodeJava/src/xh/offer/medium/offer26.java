package xh.offer.medium;

import xh.*;

public class offer26 {
    public boolean isSubStructure(TreeNode A, TreeNode B) {
        if (A == null || B == null)
            return false;
        return isSameTree(A, B) || isSubStructure(A.left, B) || isSubStructure(A.right, B);
    }

    boolean isSameTree(TreeNode A, TreeNode B) {
        if (B == null)
            return true;
        if (A == null || A.val != B.val)
            return false;
        return isSameTree(A.left, B.left) && isSameTree(A.right, B.right);
    }
}
