package xh.offer.medium;

import xh.*;

public class offer7 {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder.length == 0) {
            return null;
        }
        if (preorder.length == 1) {
            return new TreeNode(preorder[0]);
        }
        return buildTree(preorder, 0, preorder.length - 1, inorder, 0, preorder.length - 1);
    }

    public TreeNode buildTree(int[] preorder, int start, int end, int[] inorder, int startIn, int endIn) {
        if (start > end) {
            return null;
        }
        if (start == end) {
            return new TreeNode(preorder[start]);
        }
        int rootVal = preorder[start];
        TreeNode node = new TreeNode(rootVal);
        int index = startIn;
        while (inorder[index] != rootVal && index <= endIn) {
            index++;
        }
        int leftSize = index - startIn;
        node.left = buildTree(preorder, start + 1, start + leftSize, inorder, startIn, index - 1);
        node.right = buildTree(preorder, start + leftSize + 1, end, inorder, index + 1, endIn);
        return node;
    }
}
