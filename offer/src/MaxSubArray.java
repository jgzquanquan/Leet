/**
 * @author jgz
 * @Date 2020-03-18 10:41
 */
public class MaxSubArray {

    //    基本规律
    public int maxSubArray(int[] nums) {
        int curSum = 0;
        int maxSum = -Integer.MAX_VALUE;
        for (int i=0; i<nums.length; i++){
            if (curSum < 0){
                curSum = nums[i];
            }else {
                curSum += nums[i];
            }
            if (curSum > maxSum){
                maxSum = curSum;
            }
        }
        return maxSum;
    }

    //    贪心算法
    public int maxSubArray1(int[] nums) {
        int curSum = nums[0];
        int maxSum = nums[0];
        for (int i=1; i<nums.length; i++){
            curSum = Math.max(nums[i], curSum+nums[i]);
            maxSum = Math.max(maxSum, curSum);
        }
        return maxSum;
    }

    // 动态规划 使用额外空间
    public int maxSubArray2(int[] nums) {
        int[]dp = new int[nums.length];
        dp[0] = nums[0];
        int maxSum = dp[0];
        for (int i=1; i<nums.length; i++){
            dp[i] = nums[i] + (dp[i-1] > 0 ? dp[i-1] : 0);
            maxSum = Math.max(maxSum, dp[i]);
        }
        return maxSum;
    }

    // 动态规划 不用额外空间
    public int maxSubArray3(int[] nums) {
        int maxSum = nums[0];
        for (int i=1; i<nums.length; i++){
            if(nums[i-1] > 0) nums[i] += nums[i-1];
            maxSum = Math.max(maxSum, nums[i]);
        }
        return maxSum;
    }

}
