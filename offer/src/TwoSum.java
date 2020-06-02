/**
 * @author jgz
 * @Date 2020-03-25 14:56
 */
public class TwoSum {
    public int[] twoSum(int[] nums, int target) {
        int i=0, j=nums.length-1;
        while (i < j){
            if (nums[i] + nums[j] == target){
                return new int[]{nums[i], nums[j]};
            }else if (nums[i] + nums[j] > target){
                j--;
            }else {
                i++;
            }
        }
        return new int[0];
    }
}
