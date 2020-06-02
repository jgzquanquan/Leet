package backtrack;

import java.util.ArrayList;
import java.util.List;

/**
 * @author jgz
 * @Date 2020-05-27 12:06
 */
public class Permutations {

    List<List<Integer>> res = new ArrayList<>();
    public List<List<Integer>> permute(int[] nums) {
        //记录路径
        List<Integer> trace = new ArrayList<>();
        backtrack(nums, trace);
        return res;
    }
    // 路径：记录在 trace 中
    // 选择列表：nums 中不存在于 trace 的那些元素
    // 结束条件：nums 中的元素全都在 trace 中出现
    private void backtrack(int[] nums, List<Integer> trace) {
        if (trace.size() == nums.length){
            res.add(new ArrayList<>(trace));
        }

        for (int num : nums){
            // 排除不合法的选择
            if (trace.contains(num)){
                continue;
            }
            // 做选择
            trace.add(num);
            // 进入下一层决策树
            backtrack(nums,trace);
            // 取消选择
            trace.remove(trace.size()-1);
        }
    }
}
