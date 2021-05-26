import java.util.Scanner;
import java.util.Stack;

public class lc946offer31 {
    /**
     * 剑指 Offer 31. 栈的压入、弹出序列
     * https://leetcode-cn.com/problems/zhan-de-ya-ru-dan-chu-xu-lie-lcof/
     * 
     * @param strings
     */
    public static void main(String[] strings) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] pushed = new int[n];
        int[] popped = new int[n];
        for (int i = 0; i < n; i++) {
            int num = sc.nextInt();
            pushed[i] = num;
        }
        for (int i = 0; i < n; i++) {
            int num = sc.nextInt();
            popped[i] = num;
        }
        System.out.println(validateStackSequences(pushed, popped));
        sc.close();
    }

    public static boolean validateStackSequences(int[] pushed, int[] popped) {
        Stack<Integer> stack = new Stack<>();
        int count = 0;
        for (int i = 0; i < pushed.length; i++) {
            stack.push(pushed[i]);
            while (!stack.isEmpty() && stack.peek() == popped[count]) {
                stack.pop();
                count++;
            }
        }
        return stack.isEmpty();
    }
}
