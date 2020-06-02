/**
 * @author jgz
 * @Date 2020-03-24 10:25
 */
public class Massage {
    /**
     * 递推方程
     * dp[i][0] = max(dp[i - 1][0], dp[i - 1][1])
     * dp[i][1] = dp[i - 1][0] + nums[i]
     * @param nums
     * @return
     */
    public int massage(int[] nums) {
        int len = nums.length;
        if (len == 0){
            return 0;
        }
        int[][]dp = new int[len][2];
        dp[0][0] = 0;
        dp[0][1] = nums[0];
        for (int i=1; i<len; i++){
            dp[i][0] = Math.max(dp[i-1][0], dp[i-1][1]);
            dp[i][1] = dp[i-1][0] + nums[i];
        }
        return Math.max(dp[len-1][0], dp[len-1][1]);
    }

    public int massage1(int[] nums) {
        int len = nums.length;
        if (len == 0){
            return 0;
        }
        int dp0 = 0;
        int dp1 = nums[0];
        for (int i=1; i<len; i++){
            int temp = dp0;
            dp0 = Math.max(dp0, dp1);
            dp1 = temp + nums[i];
        }
        return Math.max(dp0, dp1);
    }
}
