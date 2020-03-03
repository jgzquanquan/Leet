import java.util.Stack;

/**
 * @author jgz
 * @Date 2020-03-01 21:26
 */
public class CQueue1 {

    private Stack<Integer> s1;
    private Stack<Integer> s2;
    public CQueue1() {
        s1 = new Stack<>();
        s2 = new Stack<>();
    }

    public void appendTail(int value) {
        s1.push(value);
    }

    public int deleteHead() {
        if (s2.isEmpty()){
            if (s1.isEmpty()) return -1;
            else while (!s1.isEmpty()) s2.push(s1.pop());
        }
        return s2.pop();
    }
}
