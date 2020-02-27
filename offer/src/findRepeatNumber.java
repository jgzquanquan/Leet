import java.util.HashMap;
import java.util.Map;

/**
 * @author jgz
 * @Date 2020-02-26 11:52
 */
public class findRepeatNumber {
    public int findRepeatNumber(int[] nums) {
        Map<Integer,Integer> map = new HashMap<>();
        for (int num:nums){
            if (map.containsKey(num)) return map.get(num);
            map.put(num,1);
        }
        return -1;
    }

    public int findRepeatNumber1(int[] nums) {
        int temp;
        for (int i=0;i<nums.length;i++){
            while (nums[i]!=i){
                if (nums[i]==nums[nums[i]]) return nums[i];
                temp = nums[i];
                nums[i] = nums[nums[i]];
                nums[temp] = temp;
            }
        }
        return -1;
    }
}
