package offeragain;

/**
 * @author jgz
 * @Date 2020-06-03 11:28
 */
public class CuttingRope14 {

    // 贪心思路
    public int cuttingRope(int n) {
        if (n < 4){
            return  n-1;
        }
        long res = 1;
        long mod = 1000000007;
        while (n > 4){
            res = res * 3 % mod;
            n = n - 3;
        }
        return (int) (res * n % mod);
    }

    public int cuttingRope1(int n) {
        if (n < 4){
            return  n-1;
        }
        int[] dp = new int[n+1];
        dp[1] = 1;
        dp[2] = 1;
        for (int i=3; i<=n; i++){
            for (int k=2; k<=i-1; k++){
                dp[i] = Math.max(dp[i], Math.max(k * (i-k), k * dp[i-k]));
            }
        }
        return dp[n];
    }


}
