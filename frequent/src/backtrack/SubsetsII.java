package backtrack;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * @author jgz
 * @Date 2020-05-27 15:38
 */
public class SubsetsII {

    List<List<Integer>> res = new ArrayList<>();
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        LinkedList track = new LinkedList();
        backTrack(nums, track, 0);
        return res;
    }

    private void backTrack(int[] nums, LinkedList track, int start) {
        res.add(new ArrayList<>(track));
        for (int i=start; i<nums.length; i++){
            if (i>0 && nums[i] == nums[i-1]){
                continue;
            }
            track.add(nums[i]);
            backTrack(nums, track, i+1);
            track.removeLast();
        }
    }
}
