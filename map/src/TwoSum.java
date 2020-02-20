import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TwoSum {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer,Integer> map = new HashMap<>();
        for (int i=0;i<nums.length;i++){
            if (map.get(target-nums[i]) != null){
                return new int[]{i, map.get(target - nums[i])};
            }
            map.put(nums[i],i);
        }
        return new int[0];
    }

    public int[] twoSum1(int[] nums, int target) {
        if(nums.length==0) return new int[0];
        Map<Integer,Integer> map = new HashMap<>();
        int[] res = new int[2];
        for(int i=0;i<nums.length;i++){
            if(map.containsKey(target-nums[i])){
                res[0] = i;
                res[1] = map.get(target-nums[i]);
                return res;
            }
            map.put(nums[i],i);
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(new TwoSum().twoSum( new int[] {2,7,11,15},9));
    }
}
