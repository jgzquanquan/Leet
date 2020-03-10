/**
 * @author jgz
 * @Date 2020-03-09 08:46
 */
public class BestTimetoBuyandSellStock {
    public int maxProfit(int[] prices) {
        int maxprofit = 0;
        for (int i=0; i<prices.length; i++){
            for (int j=i+1; j<prices.length; j++){
                if (prices[j] - prices[i] > maxprofit){
                    maxprofit = prices[j] - prices[i];
                }
            }
        }
        return maxprofit;
    }

    public int maxProfit1(int[] prices) {
        int minprice = Integer.MAX_VALUE;
        int maxprofit = 0;
        for (int i=0; i<prices.length; i++){
            if (prices[i] < minprice){
                minprice = prices[i];
            }else {
                if (prices[i] - minprice > maxprofit){
                    maxprofit = prices[i] - minprice;
                }
            }
        }
        return maxprofit;
    }
//dp状态转移框架
    public int maxProfit2(int[] prices) {
        if (prices == null || prices.length == 0){
            return 0;
        }
        int[][]dp = new int[prices.length][2];
        dp[0][0] = 0;
        dp[0][1] = -prices[0];
        for (int i=1; i<prices.length; i++){
            dp[i][0] = Math.max(dp[i-1][0], dp[i-1][1] + prices[i]);
            dp[i][1] = Math.max(dp[i-1][1], -prices[i]);
        }
        return dp[prices.length-1][0];
    }

    public int maxProfit3(int[] prices) {
        int dp_i_0 = 0;
        int dp_i_1 = -Integer.MAX_VALUE;
        for (int i=0; i<prices.length; i++){
            dp_i_0 = Math.max(dp_i_0, dp_i_1 + prices[i]);
            dp_i_1 = Math.max(dp_i_1, -prices[i]);
        }
        return dp_i_0;
    }

}
