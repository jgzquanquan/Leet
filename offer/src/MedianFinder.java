import java.util.Collections;
import java.util.PriorityQueue;

/**
 * @author jgz
 * @Date 2020-03-17 14:47
 */
public class MedianFinder {

    /** initialize your data structure here. */
    private PriorityQueue<Integer> small;
    private PriorityQueue<Integer> large;
    private boolean even;
    public MedianFinder() {
//        small = new PriorityQueue<>(Collections.reverseOrder());
        small = new PriorityQueue<>((o1, o2) -> o2 - o1);
        large = new PriorityQueue<>();
        even = true;
    }

    public void addNum(int num) {
        if (even){
            large.add(num);
            small.add(large.remove());
        }else {
            small.add(num);
            large.add(small.remove());
        }
        even = !even;
    }

    public double findMedian() {
        if (even){
            return (small.peek() + large.peek()) / 2.0;
        }else {
            return small.peek();
        }
    }
}
