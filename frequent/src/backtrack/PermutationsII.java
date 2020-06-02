package backtrack;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author jgz
 * @Date 2020-05-27 14:52
 */
public class PermutationsII {

    List<List<Integer>> res = new ArrayList<>();
    public List<List<Integer>> permuteUnique(int[] nums) {
        boolean[] visted = new boolean[nums.length];
        Arrays.sort(nums);
        ArrayDeque track = new ArrayDeque();
        backtrack(nums, visted, track);
        return res;
    }

    private void backtrack(int[] nums, boolean[] visted, ArrayDeque track) {
        if (track.size() == nums.length){
            res.add(new ArrayList<>(track));
        }
        for (int i=0; i<nums.length; i++){
            if (visted[i]){
                continue;
            }
            //visted[i-1] == false代表相同的数是刚刚被撤销，如果没有这个会导致剪枝剪多了
            if (i>0 && nums[i] == nums[i-1] && visted[i-1] == false){
                continue;
            }
            visted[i] = true;
            track.addLast(nums[i]);
            backtrack(nums,visted,track);
            visted[i] = false;
            track.removeLast();
        }
    }

    public static void main(String[] args) {
        new PermutationsII().permuteUnique(new int[]{1,1,2});
    }
}
