/**
 * @author jgz
 * @Date 2020-05-18 08:32
 */
public class MaximumProductSubarray {
    public int maxProduct(int[] nums) {
        int[] maxdp = new int[nums.length];
        int[] mindp = new int[nums.length];
        int res = nums[0];
        maxdp[0] = nums[0];
        mindp[0] = nums[0];
        for(int i = 1; i < nums.length; i++){
            if (nums[i] >= 0){
                maxdp[i] = Math.max(nums[i], nums[i] * maxdp[i-1]);
                mindp[i] = Math.min(nums[i], nums[i] * mindp[i-1]);
            } else {
                maxdp[i] = Math.max(nums[i], nums[i] * mindp[i-1]);
                mindp[i] = Math.min(nums[i], nums[i] * maxdp[i-1]);
            }
            res = Math.max(res, maxdp[i]);
        }
        return res;
    }

    public int maxProduct1(int[] nums) {
        int maxdp = nums[0], mindp = nums[0], res = nums[0];
        for (int i=1; i < nums.length; i++){
            int mx = maxdp, mn = mindp;
            if (nums[i] >= 0){
                maxdp = Math.max(nums[i], nums[i] * mx);
                mindp = Math.min(nums[i], nums[i] * mn);
            } else {
                maxdp = Math.max(nums[i], nums[i] * mn);
                mindp = Math.min(nums[i], nums[i] * mx);
            }
            res = Math.max(res, maxdp);
        }
        return res;
    }
}
