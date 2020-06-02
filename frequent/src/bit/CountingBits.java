package bit;

/**
 * @author jgz
 * @Date 2020-04-28 15:38
 */
public class CountingBits {
    public int[] countBits(int num) {
        int[] dp = new int[num + 1];
        for (int i = 1; i <= num; i++){
            dp[i] = dp[i >> 1] + (i & 1);
        }
        return dp;
    }

    public int[] countBits1(int num) {
        int[] dp = new int[num + 1];
        for (int i = 1; i <= num; i++){
            dp[i] = dp[i & (i-1)] + 1;
        }
        return dp;
    }
}
