import java.util.Arrays;

/**
 * @author jgz
 * @Date 2020-03-08 08:41
 */
public class CoinChange {
//
    public int coinChange(int[] coins, int amount) {
        if (amount < 1) return 0;
        int[] count = new int[amount + 1];
        return coinChange(coins, amount, count);
    }

    private int coinChange(int[] coins, int amount, int[] count) {
        if (amount == 0) return 0;
        if (amount < 0) return -1;
        if (count[amount] != 0) return count[amount];
        int min = Integer.MAX_VALUE;
        for (int coin : coins){
            int res = coinChange(coins, amount-coin, count);
            if (res >= 0 && res < min){
                min = res + 1;
            }
        }
        count[amount] = (min == Integer.MAX_VALUE) ? -1 : min;
        return count[amount];
    }

    public int coinChange1(int[] coins, int amount) {
        if (amount < 1) return 0;
        int[] dp = new int[amount + 1];
        Arrays.fill(dp, amount + 1);
        dp[0] = 0;
        for (int i=1; i<=amount; i++){
            for (int j=0; j<coins.length; j++){
                if (i - coins[j] >= 0){
                    dp[i] = Math.min(dp[i],dp[i-coins[j]]+1);
                }
            }
        }
        return dp[amount] > amount ? -1 : dp[amount];
    }



}
