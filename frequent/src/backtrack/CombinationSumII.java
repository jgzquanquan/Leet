package backtrack;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * @author jgz
 * @Date 2020-05-28 10:49
 */
public class CombinationSumII {

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<List<Integer>> res = new ArrayList<>();
        LinkedList<Integer> track = new LinkedList<>();
        backTrack(candidates, target, track, 0, res);
        return res;
    }

    private void backTrack(int[] candidates, int target, LinkedList<Integer> track, int start, List<List<Integer>> res) {
        if (target == 0) {
            res.add(new LinkedList<>(track));
        }
        for (int i = start; i<candidates.length; i++){
            if (target - candidates[i] < 0){
                return;
            }
            if (i > start && candidates[i] == candidates[i-1]){
                continue;
            }
            track.add(candidates[i]);
            backTrack(candidates, target - candidates[i], track, i+1, res);
            track.removeLast();
        }
    }
}
