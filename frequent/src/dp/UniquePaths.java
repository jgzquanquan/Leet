package dp;

/**
 * @author jgz
 * @Date 2020-05-29 11:26
 */
public class UniquePaths {
    public int uniquePaths(int m, int n) {
        int[][] dp = new int[m+1][n+1];
        dp[0][1] = 1;
        for (int i=1; i<=m; i++){
            for (int j=1; j<=n; j++){
                dp[i][j] = dp[i][j-1] + dp[i-1][j];
            }
        }
        return dp[m][n];
    }
}
