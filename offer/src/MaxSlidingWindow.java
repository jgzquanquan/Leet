import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;

/**
 * @author jgz
 * @Date 2020-03-07 09:57
 */
public class MaxSlidingWindow {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int n = nums.length;
        if (n * k == 0) return new int[0];
        Deque<Integer> deque = new ArrayDeque<>();
        int[] res = new int[n-k+1];
        for (int i=0; i<n; i++){
            if (i >= k && deque.peek() <= i-k){
                deque.remove();
            }
            while (!deque.isEmpty() && nums[deque.peekLast()] < nums[i]){
                deque.removeLast();
            }
            deque.add(i);
            if (i>=k-1){
                res[i-k+1] = nums[deque.peek()];
            }
        }
        return res;
    }
}
