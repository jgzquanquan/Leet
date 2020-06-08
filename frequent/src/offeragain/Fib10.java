package offeragain;

/**
 * @author jgz
 * @Date 2020-06-03 09:49
 */
public class Fib10 {
    public int fib(int n) {
        if (n<2){
            return n;
        }
        int[] dp = new int[n+1];
        dp[0] = 0;
        dp[1] = 1;
        for(int i=2; i<=n; i++){
            dp[i] = (dp[i-1] + dp[i-2]) % 1000000007;
        }
        return dp[n];
    }
}
