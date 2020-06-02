/**
 * @author jgz
 * @Date 2020-03-27 10:41
 */
public class NSum {
    public double[] twoSum(int n) {
        int[][] dp = new int[n+1][6*n+1];
        for (int i=1; i<=6; i++){
            dp[1][i] = 1;
        }
        for (int i=2; i<=n; i++){
            for (int j=i; j<=6*i; j++){
                for (int d=1; d<=6; d++){
                    if (j-d <= 0 ) break;
                    dp[i][j] += dp[i-1][j-d];
                }
            }
        }
        double total = Math.pow((double)6, (double)n);
        double[] ans = new double[5*n+1];
        for (int i=n; i<=6*n; i++){
            ans[i-n] = ((double)dp[n][i]) / total;
        }
        return ans;
    }
}
