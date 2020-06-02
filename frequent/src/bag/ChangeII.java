package bag;

/**
 * @author jgz
 * @Date 2020-04-23 17:53
 */
public class ChangeII {
    public int change(int amount, int[] coins) {
        int len = coins.length;
        if (len == 0){
            if (amount == 0){
                return 1;
            }
            return 0;
        }

        int[][] dp = new int[len+1][amount+1];
        dp[0][0] = 1;


        for (int i=1; i<=len;i++){
            for (int j=0; j<=amount;j++){
                for (int k=0;j-k*coins[i-1]>=0;k++){
                    dp[i][j] += dp[i-1][j-k*coins[i-1]];
                }
            }
        }

        return dp[len][amount];
    }

//优化状态转移方程
    public int change1(int amount, int[] coins) {
        int len = coins.length;
        if (len == 0){
            if (amount == 0){
                return 1;
            }
            return 0;
        }

        int[][] dp = new int[len+1][amount+1];
        dp[0][0] = 1;
        for (int i=1; i<=len;i++){
            for (int j=0; j<=amount;j++){
                dp[i][j] = dp[i-1][j];
                if (j >= coins[i-1]){
                    dp[i][j] += dp[i][j-coins[i-1]];
                }
            }
        }
        return dp[len][amount];
    }

    //状态压缩
    public int change2(int amount, int[] coins) {
        int len = coins.length;
        if (len == 0){
            if (amount == 0){
                return 1;
            }
            return 0;
        }
        int[] dp = new int[amount+1];
        dp[0] = 1;
        for (int i=1; i<=len;i++){
            for (int j=coins[i-1]; j<=amount; j++){
                dp[j] += dp[j - coins[i-1]];
            }
        }
        return dp[amount];
    }
}
