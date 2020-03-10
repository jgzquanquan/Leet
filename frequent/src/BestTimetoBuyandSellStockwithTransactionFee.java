/**
 * @author jgz
 * @Date 2020-03-10 15:25
 */
public class BestTimetoBuyandSellStockwithTransactionFee {
    public int maxProfit(int[] prices, int fee) {
        int dp_i0 = 0;
        int dp_i1 = -Integer.MAX_VALUE;
        for (int i=0; i<prices.length; i++){
            int temp = dp_i0;
            dp_i0 = Math.max(dp_i0, dp_i1 + prices[i]);
            dp_i1 = Math.max(dp_i1, dp_i0 - prices[i] - fee);
        }
        return dp_i0;
    }
}
