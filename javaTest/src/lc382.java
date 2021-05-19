import java.util.Random;
import java.util.*;

public class lc382 {
    public static void main(String[] strings) {
        Scanner sc = new Scanner(System.in);
        Random random = new Random();
        int i = 0;
        while (i < 100) {
            i++;
            int r = random.nextInt(i) + 1;
            if (r == i) {
                System.out.println(i + "->" + r);
            }
        }
        sc.close();
    }

    // public Solution(ListNode head) {

    // }

    // /** Returns a random node's value. */
    // public int getRandom() {

    // }
}
