import java.util.*;

/**
 * @author jgz
 * @Date 2020-02-14 10:31
 */
public class ThreeSum {
//   双指针法
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<>();
        for (int k=0;k<nums.length-2;k++){
            if (nums[k] > 0) break;
            if (k>0 && nums[k]==nums[k-1]) continue;
            for (int i=k+1,j=nums.length-1;i<j;){
                int sum = nums[k]+nums[i]+nums[j];
                if (sum==0){
                    res.add(Arrays.asList(new Integer[]{nums[k],nums[i],nums[j]}));
                    while (i<j&&nums[i]==nums[i+1])i++;
                    while (i<j&&nums[j]==nums[j-1]) j--;
                    i++;
                    j--;
                }else if (sum<0) i++;
                else j--;
            }
        }
        return res;
    }
//Hash表法
    public List<List<Integer>> threeSum1(int[] nums) {
        Arrays.sort(nums);
        Set<List<Integer>> res = new HashSet<>();
        for (int i=0;i<nums.length-1;i++){
            if (i>0 && nums[i]==nums[i--]) continue;
            Map<Integer,Integer> map = new HashMap<>();
            for (int j=i+1;j<nums.length;j++){
                if (map.containsKey(-(nums[i]+nums[j]))){
                    res.add(Arrays.asList(new Integer[]{nums[i],nums[j],-(nums[i]+nums[j])}));
                }else {
                    map.put(nums[j],1);
                }
            }
        }
        return new ArrayList<>(res);
    }
}
