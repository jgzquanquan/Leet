import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author jgz
 * @Date 2020-03-17 17:06
 */
public class SubsetII {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> list = new ArrayList<>();
        Arrays.sort(nums);
        backTrace(list, new ArrayList<Integer>(), nums, 0);
        return list;
    }

    private void backTrace(List<List<Integer>> list, ArrayList<Integer> tempList, int[] nums, int start) {
        list.add(new ArrayList<>(tempList));
        for (int i=start; i<nums.length; i++){
            if (i>start && nums[i]==nums[i-1]) continue;
            tempList.add(nums[i]);
            backTrace(list, tempList, nums, i+1);
            tempList.remove(tempList.size() - 1);
        }
    }


    public static void main(String[] args) {
        new SubsetII().subsetsWithDup(new int[]{1,2,2});
    }
}
