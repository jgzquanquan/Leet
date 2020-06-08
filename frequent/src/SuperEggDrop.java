/**
 * @author jgz
 * @Date 2020-06-07 16:54
 */
public class SuperEggDrop {
    /**
     * 方法三：数学法
     * 说明
     *
     * 方法三涉及逆向思维，是一种没见过就不太可能想出来，读过题解也很容易忘记的方法。
     *
     * 思路
     *

     The dp equation is:
     dp[m][k] = dp[m - 1][k - 1] + dp[m - 1][k] + 1,
     which means we take 1 move to a floor,
     if egg breaks, then we can check dp[m - 1][k - 1] floors.
     if egg doesn't breaks, then we can check dp[m - 1][k] floors.

     dp[m][k] is the number of combinations and it increase exponentially to N
     * @param K
     * @param N
     * @return
     */
    public int superEggDrop(int K, int N) {
        int[][] dp = new int[K+1][N+1];
        int m = 0;
        while (dp[K][m] < N){
            m++;
            for (int k=1;k<=K; k++){
                dp[k][m] = dp[k][m-1] + dp[k-1][m-1]+1;
            }
        }
        return m;
    }
}
