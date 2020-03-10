/**
 * @author jgz
 * @Date 2020-03-10 16:44
 */
public class BestTimetoBuyandSellStockIV {
    public int maxProfit(int k, int[] prices) {
        if (k >= prices.length >>> 1){
            int dp_i0 = 0;
            int dp_i1 = -Integer.MAX_VALUE;
            for (int price : prices){
                int temp = dp_i0;
                dp_i0 = Math.max(dp_i0, dp_i1 + price);
                dp_i1 = Math.max(dp_i1, temp - price);
            }
            return dp_i0;
        }

        int[] dp_ik0 = new int[k+1];
        int[] dp_ik1 = new int[k+1];
        for (int price : prices){
            for (int j=k; j>0; j--){
                dp_ik0[j] = Math.max(dp_ik0[j], dp_ik1[j] + price);
                dp_ik1[j] = Math.max(dp_ik1[j], dp_ik0[j-1] - price);
            }
        }
        return dp_ik0[k];
    }
}
