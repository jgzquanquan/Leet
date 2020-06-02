import java.util.HashMap;
import java.util.Map;

/**
 * @author jgz
 * @Date 2020-05-15 09:08
 */
public class SubarraySumEqualsK {
    public int subarraySum(int[] nums, int k) {
        int pre = 0, count = 0;
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);
        for (int num : nums){
            pre += num;
            if (map.containsKey(pre - k)){
                count += map.get(pre - k);
            }
            map.put(pre, map.getOrDefault(pre, 0)+1);
        }
        return count;
    }
}
