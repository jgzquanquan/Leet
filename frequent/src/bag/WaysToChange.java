package bag;

/**
 * @author jgz
 * @Date 2020-04-23 18:40
 */
public class WaysToChange {
    public int waysToChange(int n) {
        int[] coins = new int[]{1,5,10,25};
        int[] dp = new int[n+1];
        dp[0] = 1;
        for (int coin : coins){
            for (int j=coin;j<=n;j++){
                dp[j] += dp[j-coin];
            }
        }
        return dp[n];

    }
}
