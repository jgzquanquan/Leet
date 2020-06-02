package bag;

/**
 * @author jgz
 * @Date 2020-05-30 11:56
 */
public class PartitionEqualSubsetSum {
    public boolean canPartition(int[] nums) {
        int sum = 0;
        for (int num : nums){
            sum += num;
        }
        if ((sum & 1) == 1){
            return false;
        }

        int target = sum >> 1;
        boolean[][] dp = new boolean[nums.length+1][target+1];
        dp[0][0] = true;
        for (int i = 1; i<=nums.length; i++){
            for (int j=0; j<=target; j++){
                if (j - nums[i-1] >= 0){
                    dp[i][j] = dp[i-1][j-nums[i-1]] || dp[i-1][j];
                    continue;
                } else {
                    dp[i][j] = dp[i-1][j];
                }
            }
            if (dp[i][target]){
                    return true;
            }
        }

        return dp[nums.length][target];
    }

    public boolean canPartition1(int[] nums) {
        int sum = 0;
        for (int num : nums){
            sum += num;
        }
        if ((sum & 1) == 1){
            return false;
        }

        int target = sum >> 1;
        boolean[] dp = new boolean[target+1];
        dp[0] = true;
        for (int i = 1; i<=nums.length; i++){
            for (int j=target; j>=nums[i-1]; j--){
                dp[j] = dp[j-nums[i-1]] || dp[j];
            }
            if (dp[target]){
                return true;
            }
        }

        return dp[target];
    }

    public static void main(String[] args) {
        new PartitionEqualSubsetSum().canPartition(new int[]{1,5,11,5});
    }
}
