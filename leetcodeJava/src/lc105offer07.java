import java.util.HashMap;
import java.util.Scanner;

public class lc105offer07 {
    /**
     * 剑指 Offer 07. 重建二叉树
     * https://leetcode-cn.com/problems/zhong-jian-er-cha-shu-lcof/
     * https://leetcode-cn.com/problems/construct-binary-tree-from-preorder-and-inorder-traversal/
     * 
     * @param strings
     */
    public static void main(String[] strings) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] preorder = new int[n];
        int[] inorder = new int[n];
        for (int i = 0; i < n; i++) {
            int num = sc.nextInt();
            preorder[i] = num;
        }
        for (int i = 0; i < n; i++) {
            int num = sc.nextInt();
            inorder[i] = num;
        }
        sc.close();
        TreeNode ret = buildTree(preorder, inorder);
        System.out.println(ret);
    }

    static HashMap<Integer, Integer> indexMap = new HashMap<>();

    public static TreeNode buildTree(int[] preorder, int[] inorder) {
        if (inorder.length == 0) {
            return null;
        }
        indexMap = new HashMap<Integer, Integer>();
        for (int i = 0; i < inorder.length; i++) {
            indexMap.put(inorder[i], i);
        }
        return recur(preorder, inorder, 0, preorder.length - 1, 0, inorder.length - 1);
    }

    public static TreeNode recur(int[] preorder, int[] inorder, int preorder_left, int preorder_right, int inorder_left,
            int inorder_right) {
        if (preorder_left > preorder_right)
            return null;
        int preorder_root = preorder_left;
        int inorder_root = indexMap.get(preorder[preorder_root]);
        TreeNode root = new TreeNode(preorder[preorder_root]);
        int size_left_subtree = inorder_root - inorder_left;
        root.left = recur(preorder, inorder, preorder_left + 1, preorder_left + size_left_subtree, inorder_left,
                inorder_root - 1);
        root.right = recur(preorder, inorder, preorder_left + size_left_subtree + 1, preorder_right, inorder_root + 1,
                inorder_right);
        return root;
    }
}
