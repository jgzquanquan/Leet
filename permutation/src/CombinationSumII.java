import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author jgz
 * @Date 2020-03-17 22:40
 */
public class CombinationSumII {

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> list = new ArrayList<>();
        Arrays.sort(candidates);
        backTrace(list, new ArrayList<Integer>(), target, candidates, 0);
        return list;
    }

    private void backTrace(List<List<Integer>> list, ArrayList<Integer> tempList, int target, int[] candidates, int start) {
        if (target == 0){
            list.add(new ArrayList<>(tempList));
            return;
        }

        for (int i=start; i<candidates.length; i++){
            if (i>start && candidates[i] == candidates[i-1] || target - candidates[i] < 0){
                continue;
            }
            tempList.add(candidates[i]);
            backTrace(list, tempList, target-candidates[i], candidates, i+1);
            tempList.remove(tempList.size() - 1);
        }
    }
}
