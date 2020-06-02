/**
 * @author jgz
 * @Date 2020-05-03 08:42
 */
public class MaximumSubarray {
    public int maxSubArray(int[] nums) {
        int sum = 0;
        int max = Integer.MIN_VALUE;
        for (int num : nums){
            if (sum < 0){
                sum = num;
            } else {
                sum += num;
            }
            max = Math.max(sum, max);
        }
        return max;
    }

    public int maxSubArray2(int[] nums) {
        int sum = 0;
        int max = Integer.MIN_VALUE;
        for (int num : nums){
            sum = Math.max(num, sum+num);
            max = Math.max(sum, max);
        }
        return max;
    }

    public int maxSubArray3(int[] nums) {
        int len = nums.length;
        if(nums == null || len == 0){
            return 0;
        }
        int[] dp = new int[len];
        dp[0] = nums[0];
        int max = nums[0];
        for(int i=1; i<len; i++){
            if(dp[i-1] < 0){
                dp[i] = nums[i];
            } else{
                dp[i] = dp[i-1] + nums[i];
            }
            max = Math.max(dp[i],max);
        }
        return max;
    }

    public static void main(String[] args) {
        new MaximumSubarray().maxSubArray3(new int[]{-2,1,-3,4,-1,2,1,-5,4});
    }
}
