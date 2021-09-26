package xh.offer.medium;

public class offer33 {
    public boolean verifyPostorder(int[] postorder) {
        if (postorder.length < 2) {
            return true;
        }
        return verifyPostorder(postorder, 0, postorder.length - 1);
    }

    public boolean verifyPostorder(int[] postorder, int start, int end) {
        if (end - start < 1) {
            return true;
        }
        int rootVal = postorder[end];
        int l = start;
        while (l < end && postorder[l] <= rootVal) {
            l++;
        }
        int r = end;
        while (r >= l && postorder[r] >= rootVal) {
            r--;
        }
        if (l - r == 1) {
            return verifyPostorder(postorder, start, r) && verifyPostorder(postorder, l, end - 1);
        }
        return false;
    }
}
