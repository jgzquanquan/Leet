import java.util.Stack;

/**
 * @author jgz
 * @Date 2020-03-12 12:06
 */
public class ValidateStackSequences {
    public boolean validateStackSequences(int[] pushed, int[] popped) {
        int j = 0;
        Stack<Integer> stack = new Stack<>();
        for(int push : pushed){
            stack.push(push);
            while (!stack.isEmpty() && stack.peek() == popped[j]){
                j++;
                stack.pop();
            }
        }
        return stack.isEmpty();
    }
}
