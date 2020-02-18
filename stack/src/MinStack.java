import java.util.Stack;

/**
 * @author jgz
 * @Date 2020-02-16 17:32
 */
public class MinStack {
    /** initialize your data structure here. */
    private Stack<Integer> stack;
    private Stack<Integer> minStack;
    private int min;
    public MinStack() {
        stack = new Stack<>();
        minStack = new Stack<>();
    }

    public void push(int x) {
        stack.push(x);
        if (!minStack.isEmpty() && minStack.peek()<x) minStack.push(minStack.peek());
        else minStack.push(x);
    }

    public void pop() {
        if (!stack.isEmpty()){
            stack.pop();
            minStack.pop();
        }else throw new RuntimeException();

    }

    public int top() {
        if ((!stack.isEmpty())){
            return stack.peek();
        }
        throw new RuntimeException();
    }

    public int getMin() {
        if (!minStack.isEmpty()) return minStack.peek();
        throw new RuntimeException();
    }
}
