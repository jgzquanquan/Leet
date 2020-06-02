package backtrack;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author jgz
 * @Date 2020-05-28 11:00
 */
public class CombinationSumIII {
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> res = new ArrayList<>();
        LinkedList<Integer> track = new LinkedList<>();
        backTrack(k, n, res, track,1);
        return res;
    }

    private void backTrack(int k, int n, List<List<Integer>> res, LinkedList<Integer> track, int start) {
        if (track.size() == k && n == 0){
            res.add(new LinkedList<>(track));
        }
        for (int i = start; i <= 9; i++){
            if (n - i < 0) {
                return;
            }
            track.add(i);
            backTrack(k, n-i, res, track,i+1);
            track.removeLast();
        }
    }
}
