/**
 * @author jgz
 * @Date 2020-03-10 10:14
 */
public class BestTimetoBuyandSellStockII {
    public int maxProfit(int[] prices) {
        if (prices == null || prices.length == 0) return 0;
        int maxProfit = 0;
        int vally = prices[0];
        int peek = prices[0];
        for (int i=0; i<prices.length - 1;){
            while (i < prices.length - 1 && prices[i] >= prices[i+1]){
                i++;
            }
            vally = prices[i];
            while (i < prices.length - 1 && prices[i] <= prices[i+1]){
                i++;
            }
            peek = prices[i];
            maxProfit += peek - vally;
        }
        return maxProfit;
    }

    public int maxProfit1(int[] prices) {
        if (prices == null || prices.length == 0) return 0;
        int maxProfit = 0;
        for (int i=1; i<prices.length; i++){
            if (prices[i] > prices[i-1]){
                maxProfit += prices[i] - prices[i-1];
            }
        }
        return maxProfit;
    }

    public int maxProfit2(int[] prices) {
        if (prices == null || prices.length == 0) return 0;
        int[][]dp = new int[prices.length][2];
        dp[0][0] = 0;
        dp[0][1] = -prices[0];
        for (int i=1; i<prices.length; i++){
            dp[i][0] = Math.max(dp[i-1][0], dp[i-1][1] + prices[i]);
            dp[i][1] = Math.max(dp[i-1][1], dp[i-1][0] - prices[i]);
        }
        return dp[prices.length-1][0];
    }

    public int maxProfit3(int[] prices) {
        int dp_i_0 = 0;
        int dp_i_1 = -Integer.MAX_VALUE;
        for (int i=0; i<prices.length; i++){
            int temp = dp_i_0;
            dp_i_0 = Math.max(dp_i_0, dp_i_1 + prices[i]);
            dp_i_1 = Math.max(dp_i_1, temp - prices[i]);
        }
        return dp_i_0;
    }

    public static void main(String[] args) {
        new BestTimetoBuyandSellStockII().maxProfit2(new int[]{1,2,3,4,5});
    }
}
