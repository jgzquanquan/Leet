import com.sun.org.apache.xml.internal.utils.res.IntArrayWrapper;

import java.util.Stack;

/**
 * @author jgz
 * @Date 2020-03-01 20:58
 */
public class CQueue {

    private Stack<Integer> s1;
    private Stack<Integer> s2;

    public CQueue() {
        s1 = new Stack<>();
        s2 = new Stack<>();
    }

    public void appendTail(int value) {
        while (!s1.isEmpty()){
            s2.push(s1.pop());
        }
        s1.push(value);
        while (!s2.isEmpty()){
            s1.push(s2.pop());
        }
    }

    public int deleteHead() {
        if (s1.isEmpty()) return -1;
        return s1.pop();
    }
}
