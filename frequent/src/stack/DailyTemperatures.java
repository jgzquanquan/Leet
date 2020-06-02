package stack;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @author jgz
 * @Date 2020-05-30 10:47
 */
public class DailyTemperatures {
    public int[] dailyTemperatures(int[] T) {
        int[] res = new int[T.length];
        if (T == null || T.length == 0){
            return res;
        }
        Deque<Integer> indexStack = new ArrayDeque<>();
        for (int i=0; i<T.length; i++){
            while (!indexStack.isEmpty() && T[indexStack.peek()] < T[i]){
                int index = indexStack.pop();
                res[index] = i-index;
            }
            indexStack.push(i);
        }
        return res;
    }
}
