import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author jgz
 * @Date 2020-03-17 18:48
 */
public class PermutationsII {
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> list = new ArrayList<>();
        Arrays.sort(nums);
        boolean[] visted = new boolean[nums.length];
        backTrace(list, new ArrayList<>(), nums, visted);
        return list;
    }

    private void backTrace(List<List<Integer>> list, List<Integer> tempList, int[] nums, boolean[] visted) {
        if (tempList.size() == nums.length){
            list.add(new ArrayList<>(tempList));
            return;
        }
        for (int i=0; i<nums.length; i++){
            if (visted[i] || i>0 && nums[i] == nums[i-1] && !visted[i-1]){
                continue;
            }
            tempList.add(nums[i]);
            visted[i] = true;
            backTrace(list, tempList, nums, visted);
            visted[i] = false;
            tempList.remove(tempList.size() - 1);
        }
    }
}
