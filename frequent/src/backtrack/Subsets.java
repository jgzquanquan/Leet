package backtrack;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author jgz
 * @Date 2020-05-27 15:24
 */
public class Subsets {
    List<List<Integer>> res = new ArrayList<>();
    public List<List<Integer>> subsets(int[] nums) {

        LinkedList track = new LinkedList();
        backtrack(nums, track, 0);
        return res;
    }

    private void backtrack(int[] nums, LinkedList track, int start) {
        res.add(new ArrayList<>(track));
        for (int i = start; i<nums.length; i++){
            track.addLast(nums[i]);
            backtrack(nums,track,i+1);
            track.removeLast();
        }
    }
}
