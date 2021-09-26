package xh.offer.medium;

import java.util.*;

public class offer31 {
    public boolean validateStackSequences(int[] pushed, int[] popped) {

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
