import java.util.Random;
import java.util.*;

public class lc382 {
    public class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    public static void main(String[] strings) {
        Scanner in = new Scanner(System.in);
        Random random = new Random();
        int i = 0;
        while (i < 100) {
            i++;
            int r = random.nextInt(i) + 1;
            if (r == i) {
                System.out.println(i + "->" + r);
            }
        }
    }

    // public Solution(ListNode head) {

    // }

    // /** Returns a random node's value. */
    // public int getRandom() {

    // }
}
