import java.util.LinkedList;
import java.util.Queue;

/**
 * @author jgz
 * @Date 2020-03-01 10:21
 */
public class ImplementStackUsingQueues2 {

    private Queue<Integer> queue;


    /** Initialize your data structure here. */
    public ImplementStackUsingQueues2() {
        queue = new LinkedList<>();
    }

    /** Push element x onto stack. */
    public void push(int x) {
        int size = queue.size();
        queue.add(x);
        for (int i=0; i<size; i++){
            queue.add(queue.remove());
        }

    }

    /** Removes the element on top of the stack and returns that element. */
    public int pop() {
        return queue.remove();
    }

    /** Get the top element. */
    public int top() {
        return queue.peek();
    }

    /** Returns whether the stack is empty. */
    public boolean empty() {
        return queue.isEmpty();
    }
}
