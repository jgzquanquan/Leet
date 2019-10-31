import java.util.PriorityQueue;
import java.util.Queue;

//703
public class KthLargest {
    private Queue<Integer> q;
    private int k;
    public KthLargest(int k, int[] nums) {
        this.k = k;
        q = new PriorityQueue<>();
        for (int num : nums){
            add(num);
        }
    }

    public int add(int val) {
        if (q.size() < k){
            q.offer(val);
        }else if (q.peek() < val){
            q.remove();
            q.offer(val);
        }
        return q.peek();
    }
}
