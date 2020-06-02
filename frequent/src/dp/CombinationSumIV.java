package dp;

/**
 * @author jgz
 * @Date 2020-05-28 11:18
 * 可以使用回溯来做，但是会超时，由于没有需要得到具体的组合，只是需要数量，因此可以使用动态规划
 */

//这题可以和零钱兑换中的第二题结合来看
public class CombinationSumIV {
    public int combinationSum4(int[] nums, int target) {
        int[] dp = new int[target + 1];
        dp[0] = 0;
        for (int i = 1; i<=target; i++){
            for (int num : nums){
                if (i - num >= 0){
                    dp[i] += dp[i-num];
                }
            }
        }
        return dp[target];
    }
}
