import java.util.Stack;

/**
 * @author jgz
 * @Date 2020-03-11 12:12
 */
public class MinStack {
    /** initialize your data structure here. */
    Stack<Integer> stack;
    Stack<Integer> minStack;
    public MinStack() {
        stack = new Stack<>();
        minStack = new Stack<>();
    }

    public void push(int x) {
        stack.push(x);
        if (!minStack.isEmpty() && minStack.peek() < x){
            minStack.add(minStack.peek());
            return;
        }
        minStack.add(x);
    }

    public void pop() {
        if (stack.isEmpty()) return;
        stack.pop();
        minStack.pop();
    }

    public int top() {
        if (stack.isEmpty()) return -1;
        return stack.peek();
    }

    public int min() {
        if (minStack.isEmpty()) return -1;
        return minStack.peek();
    }

    public static void main(String[] args) {
        MinStack stack = new MinStack();
        stack.push(-2);
        stack.push(-0);
        stack.push(-3);
        stack.min();
        stack.pop();
        stack.top();
        stack.min();
    }
}
