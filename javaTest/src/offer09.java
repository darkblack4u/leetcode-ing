import java.util.Stack;

public class offer09 {
    /**
     * 剑指 Offer 09. 用两个栈实现队列
     * https://leetcode-cn.com/problems/yong-liang-ge-zhan-shi-xian-dui-lie-lcof/
     * 
     * @param strings
     */
    public static void main(String[] strings) {

    }

    Stack<Integer> in = null;
    Stack<Integer> out = null;

    public offer09() {
        this.in = new Stack<Integer>();
        this.out = new Stack<Integer>();
    }

    public void appendTail(int value) {
        this.in.push(value);
    }

    public int deleteHead() {
        if (this.out.empty()) {
            while (!this.in.empty()) {
                this.out.push(this.in.pop());
            }
        }
        if (this.out.empty()) {
            return -1;
        } else {
            return this.out.pop();
        }
    }
}
