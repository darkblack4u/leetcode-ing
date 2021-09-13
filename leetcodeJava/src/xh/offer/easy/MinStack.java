package xh.offer.easy;

import java.util.*;

public class MinStack {
    Stack<Integer> A, B;

    public MinStack() {
        A = new Stack<>();
        B = new Stack<>();
    }

    public void push(int x) {
        A.add(x);
        if (B.empty()) {
            B.add(x);
        } else {
            B.add(B.peek() >= x ? x : B.peek());
        }
    }

    public void pop() {
        A.pop();
        B.pop();
    }

    public int top() {
        return A.peek();
    }

    public int min() {
        return B.peek();
    }
}
