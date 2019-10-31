import java.util.PriorityQueue;
import java.util.Queue;

//215
public class FindKthLargest {

    public int findKthLargest(int[] nums, int k) {
        Queue<Integer> q = new PriorityQueue<>();
        for (int num : nums){
            if (q.size() < k){
                q.add(num);
            }else if (q.peek() < num){
                q.remove();
                q.add(num);
            }
        }
        return q.peek();
    }
}
