package xh.hot100.medium;

import java.util.*;

public class leetcode739 {
    public static void main(String[] args) {
        int[] temperatures = new int[] { 73, 74, 75, 71, 69, 72, 76, 73 };
        System.out.println(dailyTemperatures(temperatures));
    }

    public static int[] dailyTemperatures(int[] temperatures) {
        int length = temperatures.length;
        int[] ans = new int[length];
        Deque<Integer> stack = new LinkedList<Integer>();
        for (int i = 0; i < length; i++) {
            int temperature = temperatures[i];
            while (!stack.isEmpty() && temperature > temperatures[stack.peek()]) {
                int prevIndex = stack.pop();
                ans[prevIndex] = i - prevIndex;
            }
            stack.push(i);
        }
        return ans;
    }
}
