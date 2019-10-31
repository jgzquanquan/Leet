import java.util.*;

//15
public class ThreeSum {
    public List<List<Integer>> threeSum(int[] nums) {
        Set<List<Integer>> res = new HashSet<>();
        //为了防止出现大量重的
        Arrays.sort(nums);
        for (int i=0;i<nums.length-1;i++) {
            //如果和前一个相同则跳过
            if (i>=1 && nums[i] == nums[i-1]){
                continue;
            }
            //这里就和两数之和逻辑一样
            Map<Integer,Integer> map = new HashMap<>();
            for (int j = i+1; j < nums.length; j++) {
                if (map.get(-nums[i]-nums[j]) != null) {
                    List<Integer> list = Arrays.asList(new Integer[]{nums[i],-(nums[i] + nums[j]),nums[j]});
                    res.add(list);
                } else {
                    map.put(nums[j],1);
                }
            }
        }
        return new ArrayList<>(res);
    }
}
