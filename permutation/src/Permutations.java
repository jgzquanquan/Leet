import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author jgz
 * @Date 2020-03-17 17:30
 */
public class Permutations {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> list = new ArrayList<>();
//        在这里因为是没有重复数字的所以没必要
//        Arrays.sort(nums);
        backTrace(list, new ArrayList<>(), nums);
        return list;
    }

    private void backTrace(List<List<Integer>> list, List<Integer> tempList, int[] nums) {
        if (tempList.size() == nums.length){
            list.add(new ArrayList<>(tempList));
            return;
        }
        for (int i=0; i<nums.length; i++){
            if (tempList.contains(nums[i])) continue;
            tempList.add(nums[i]);
            backTrace(list, tempList, nums);
            tempList.remove(tempList.size()-1);
        }
    }
}
