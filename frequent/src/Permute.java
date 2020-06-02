import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author jgz
 * @Date 2020-04-25 21:57
 */
public class Permute {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        backTrack(res, nums, new ArrayList<>());
        return res;
    }

    private void backTrack(List<List<Integer>> res, int[] nums, ArrayList<Integer> list) {
        if (list.size() == nums.length){
            res.add(new ArrayList<>(list));
            return;
        }
        for (int i=0; i<nums.length; i++){
            if (list.contains(nums[i])) continue;
            list.add(nums[i]);
            backTrack(res, nums, list);
            list.remove(list.size()-1);
        }
    }
}
