package stack;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.Map;

/**
 * @author jgz
 * @Date 2020-05-30 10:57
 */
public class NextGreaterElementI {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        int[] res = new int[nums1.length];
        if (nums1 == null || nums1.length == 0){
            return res;
        }
        Map<Integer,Integer> map = new HashMap<>();
        Deque<Integer> stack = new ArrayDeque<>();
        for (int num : nums2){
            while (!stack.isEmpty() && stack.peek() < num){
                map.put(stack.pop(), num);
            }
            stack.push(num);
        }

        while (!stack.isEmpty()){
            map.put(stack.pop(), -1);
        }

        for (int i=0; i<nums1.length; i++){
            res[i] = map.get(nums1[i]);
        }
        return res;
    }
}
