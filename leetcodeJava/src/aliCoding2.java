import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class aliCoding2 {
    public static void main(String[] args) throws Exception {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int m = in.nextInt();
        int[] preorder = new int[n];
        int[] ret = new int[n];
        int i = 0;
        while (i < n) {
            preorder[i] = in.nextInt();
            i++;
        }
        in.close();
        if (n < 2 || m == 0) {
            ret = preorder;
        } else {
            Queue<Integer> queue = new LinkedList<Integer>();
            HashMap<Integer, Integer> endMap = new HashMap<>();
            queue.offer(0);
            endMap.put(0, n - 1);
            ret[0] = preorder[0];
            while (queue.size() > 0) {
                int count = queue.size();
                for (int j = 0; j < count; j++) {
                    int currentIndex = queue.poll();
                    int currentValue = preorder[currentIndex];
                    int currentEnd = endMap.getOrDefault(currentIndex, n - 1);
                    int nextIndex = currentIndex + 1;
                    int left = 0;
                    int right = 0;
                    if (nextIndex <= currentEnd && preorder[nextIndex] < currentValue) {
                        // 有左叶子
                        left = nextIndex;
                        queue.add(left);
                        endMap.put(left, nextIndex);
                        nextIndex++;
                    }
                    while (nextIndex <= currentEnd) {
                        int nextValue = preorder[nextIndex];
                        if (nextValue > currentValue) {
                            right = nextIndex;
                            endMap.put(right, currentEnd);
                            queue.add(right);
                            break;
                        }
                        if (left != 0 && endMap.containsKey(left))
                            endMap.put(left, nextIndex);
                        nextIndex++;
                    }
                }
                // 位移数
                Integer[] a = queue.toArray(new Integer[queue.size()]);
                System.out.println(queue);
                for (int j = 0; j < a.length; j++) {
                    int oldIndex = a[j];
                    int newIndex = a[(j + m) % a.length];
                    System.out.println(oldIndex + " to " + newIndex);
                    ret[newIndex] = preorder[oldIndex];
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        for (int j = 0; j < n; j++) {
            sb.append(String.valueOf(ret[j]));
            sb.append(" ");
        }
        System.out.println(sb.toString());
    }
}
