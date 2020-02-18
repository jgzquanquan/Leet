import java.io.FileOutputStream;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Deque;

public class SlidingWindowMaximum {
    public int[] maxSlidingWindow(int[] nums, int k) {
        //进行判空
        if (nums.length == 0 || k == 0){
            return new int[0];
        }
        //存储窗口内的下标
        ArrayDeque<Integer> deque = new ArrayDeque<>();
        //保存最后的结果
        int res[] = new int[nums.length-k+1];
        for (int i=0;i<nums.length;i++){
            //如果队列长度等于k之后，这时往后移则超过，所以要先进行队首移除操作
            if (i>=k && deque.getFirst()<=i-k){
                deque.removeFirst();
            }
            //如果队列左侧的数据比新来的元素小则不停的出队
            while (deque.size()>0 && nums[deque.getLast()]<=nums[i]){
                deque.removeLast();
            }
            //将新的下标入队
            deque.add(i);
            if (i>=k-1){
                res[i+1-k]=nums[deque.getFirst()];
            }
        }
        return res;
    }











    public int[] maxSlidingWindow1(int[] nums, int k) {
        int n = nums.length;
        if (n*k==0) return new int[0];
        int[] res = new int[n-k+1];
        Deque<Integer> deque = new ArrayDeque<>();
        for (int i=0;i<n;i++){
            while (!deque.isEmpty() && deque.peek() < i-k+1)
                deque.poll();
            while (!deque.isEmpty() && nums[deque.peekLast()] < nums[i])
                deque.pollLast();
            deque.offer(i);
            if (i>=k-1) res[i+1-k] = nums[deque.peek()];
        }
        return res;
    }

    public static void main(String[] args) {
        int test[] = {1,3,1,2,0,5};
        System.out.println(new SlidingWindowMaximum().maxSlidingWindow(test,3).toString());
    }
}
