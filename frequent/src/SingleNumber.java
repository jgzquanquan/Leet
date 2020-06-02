/**
 * @author jgz
 * @Date 2020-05-14 09:16
 */
public class SingleNumber {
    public int singleNumber(int[] nums) {
        int res = 0;
        for (int i=0; i<nums.length; i++){
            res ^= nums[i];
        }
        return res;
    }
}
