package xh.online.disifanshi;

import java.util.*;

public class test3 {

    static Stack<Integer> left = new Stack<>();
    static Stack<Integer> minLeft = new Stack<>();
    static Stack<Integer> right = new Stack<>();
    static Stack<Integer> minRight = new Stack<>();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int q = sc.nextInt();
        // StringBuilder sb = new StringBuilder();
        for (int i = 0; i < q; i++) {
            String lr = sc.next();
            String pp = sc.next();
            int ret;
            if (pp.equals("pop")) {
                if (lr.equals("left")) {
                    ret = leftPop();
                } else {
                    ret = rightPop();
                }
            } else {
                int num = sc.nextInt();
                if (lr.equals("left")) {
                    ret = leftPush(num);
                } else {
                    ret = rightPush(num);
                }
            }
            System.out.println(ret);
            // sb.append(ret);
        }
        sc.close();
        // System.out.println(sb.toString());

    }

    private static int leftPush(int num) {
        left.push(num);
        if (minLeft.isEmpty()) {
            minLeft.push(num);
        } else {
            minLeft.push(Math.min(num, minLeft.peek()));
        }
        return minRight.isEmpty() ? minLeft.peek() : Math.min(minLeft.peek(), minRight.peek());
    }

    private static int rightPush(int num) {
        right.push(num);
        if (minRight.isEmpty()) {
            minRight.push(num);
        } else {
            int m = minRight.peek();
            minRight.push(Math.min(num, m));
        }
        return minLeft.isEmpty() ? minRight.peek() : Math.min(minRight.peek(), minLeft.peek());
    }

    private static int leftPop() {
        if (left.isEmpty() && right.isEmpty()) {
            return -1;
        }
        if (left.isEmpty()) {
            while (!right.isEmpty()) {
                leftPush(right.pop());
                minRight.pop();
            }
        }
        left.pop();
        minLeft.pop();

        if (right.isEmpty()) {
            return left.isEmpty() ? -1 : minLeft.peek();
        } else {
            return minLeft.isEmpty() ? minRight.peek() : Math.min(minRight.peek(), minLeft.peek());
        }
    }

    private static int rightPop() {
        if (left.isEmpty() && right.isEmpty()) {
            return -1;
        }
        if (right.isEmpty()) {
            while (!left.isEmpty()) {
                rightPush(left.pop());
                minLeft.pop();
            }
        }
        right.pop();
        minRight.pop();

        if (minLeft.isEmpty()) {
            return minRight.isEmpty() ? -1 : minRight.peek();
        } else {
            return minRight.isEmpty() ? minLeft.peek() : Math.min(minLeft.peek(), minRight.peek());
        }
    }
}