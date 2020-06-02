package bag;

/**
 * @author jgz
 * @Date 2020-05-29 14:03
 */
public class TargetSum {
    public int findTargetSumWays(int[] nums, int S) {
        int sum = 0;
        for (int num : nums){
            sum += num;
        }
        if (Math.abs(S) > Math.abs(sum)){
            return 0;
        }
        int size =  2 * sum + 1;
        int[][] dp = new int[nums.length][size];
        if (nums[0] == 0){
            dp[0][sum] = 2;
        } else {
            dp[0][sum + nums[0]] = 1;
            dp[0][sum - nums[0]] = 1;
        }


        for (int i = 1; i < nums.length; i++){
            for (int j = 0; j < size;  j++){
                int l = j - nums[i] < 0 ? 0 : j-nums[i];
                int r = j + nums[i] >= size ? size-1 : j+nums[i];
                dp[i][j] = dp[i-1][l] + dp[i-1][r];
            }
        }
        return dp[nums.length - 1][S + sum];
    }

    public static void main(String[] args) {

    }
}
