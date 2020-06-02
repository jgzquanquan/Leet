import java.util.Stack;

/**
 * @author jgz
 * @Date 2020-05-12 09:33
 */
public class MinStack {

    private Stack<Integer> stack;
    private Stack<Integer> minStack;
    /** initialize your data structure here. */
    public MinStack() {
        stack = new Stack<>();
        minStack = new Stack<>();
    }

    public void push(int x) {
        stack.push(x);
        if (!minStack.isEmpty() && minStack.peek() < x){
            minStack.push(minStack.peek());
        } else {
            minStack.push(x);
        }
    }

    public void pop() {
        if (stack.isEmpty()){
            throw new  NullPointerException();
        }
        stack.pop();
        minStack.pop();
    }

    public int top() {
        if (stack.isEmpty()){
            throw new  NullPointerException();
        }
        return stack.peek();
    }

    public int getMin() {
        if (minStack.isEmpty()){
            throw new NullPointerException();
        }
        return minStack.peek();
    }
}
