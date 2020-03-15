import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @author jgz
 * @Date 2020-03-13 10:02
 */
public class MajorityElement {
//   哈希表法
    public int majorityElement(int[] nums) {
        Map<Integer,Integer> map = new HashMap<>();
        for (int num :nums){
            int temp = map.getOrDefault(num,0);
            map.put(num, temp+1);
            if ((temp+1) > (nums.length  >>> 1)) {
                return num;
            }
        }
        return -1;
    }
//排序法 O(nLog(n))时间换空间
    public int majorityElement1(int[] nums) {
        Arrays.sort(nums);
        return nums[nums.length>>1];
    }

//    方法五：Boyer-Moore 投票算法
    public int majorityElement2(int[] nums) {
        int count = 0;
        int candidate = -1;
        for (int num : nums){
            if (count == 0){
                candidate = num;
            }
            count += (num == candidate) ? 1 : -1;
        }
        return candidate;
    }
}
