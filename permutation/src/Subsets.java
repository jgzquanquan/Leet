import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author jgz
 * @Date 2020-03-17 16:49
 */
public class Subsets {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> list = new ArrayList<>();
        Arrays.sort(nums);
        backTrack(list, new ArrayList<Integer>(), nums, 0);
        return list;
    }

    private void backTrack(List<List<Integer>> list, ArrayList<Integer> tempList, int[] nums, int start) {
        list.add(new ArrayList<>(tempList));
        for (int i=start; i<nums.length; i++){
            tempList.add(nums[i]);
            backTrack(list, tempList, nums, i+1);
            tempList.remove(tempList.size() - 1);
        }
    }
}
