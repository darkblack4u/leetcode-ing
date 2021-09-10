package xh.offer.easy;

import java.util.*;

public class CQueue {
    Stack<Integer> stack1;
    Stack<Integer> stack2;

    public CQueue() {
        stack1 = new Stack<Integer>();
        stack2 = new Stack<Integer>();
    }

    public void appendTail(int value) {
        stack1.push(value);
    }

    public int deleteHead() {
        if (stack2.size() == 0) {
            int size = stack1.size();
            for (int i = 0; i < size; i++) {
                stack2.push(stack1.pop());
            }
        }
        return stack2.size() == 0 ? -1 : stack2.pop();
    }
}
