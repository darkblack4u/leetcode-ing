public class offer33 {
    /**
     * 剑指 Offer 33. 二叉搜索树的后序遍历序列
     * https://leetcode-cn.com/problems/er-cha-sou-suo-shu-de-hou-xu-bian-li-xu-lie-lcof/
     * 
     * @param postorder
     * @return
     */
    public boolean verifyPostorder(int[] postorder) {
        if (postorder.length < 2) {
            return false;
        }
        return verifyPostorder(postorder, 0, postorder.length - 2, postorder[postorder.length - 1]);
    }

    public boolean verifyPostorder(int[] postorder, int start, int end, int root) {
        if (start > end) {
            return true;
        }
        boolean check = false;
        int index = start;
        for (int i = start; i < end + 1; i++) {
            if (postorder[i] > root) {
                check = true;
            } else {
                if (check) {
                    return false;
                }
                index = i;
            }
        }
        return verifyPostorder(postorder, start, index - 1, postorder[index])
                && verifyPostorder(postorder, index + 1, end - 1, postorder[end]);
    }
}
