package dp;

/**
 * @author jgz
 * @Date 2020-05-21 15:52
 */
public class LongestIncreasingSubsequence {
    public int lengthOfLIS(int[] nums) {
        int len = nums.length;
        if (len <= 1){
            return len;
        }
        int[] dp = new int[len];
        dp[0] = 1;
        for (int i=1; i<len; i++){
            for (int j=0; j<i; j++){
                if (nums[i] > nums[j]){
                    dp[i] = Math.max(dp[i],dp[j]+1);
                }
            }
        }
        return dp[len-1];
    }

    public static void main(String[] args) {
        new LongestIncreasingSubsequence().lengthOfLIS(new int[]{4, 10, 4, 3, 8, 9});
    }
}
