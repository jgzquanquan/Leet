import java.util.Arrays;

/**
 * @author jgz
 * @Date 2020-03-10 15:43
 */
public class BestTimetoBuyandSellStockIII {
    public int maxProfit(int[] prices) {
        int dp_i10 = 0, dp_i20 = 0;
        int dp_i11 = -Integer.MAX_VALUE, dp_i21 = -Integer.MAX_VALUE;
        for (int price : prices){
            dp_i20 = Math.max(dp_i20, dp_i21 + price);
            dp_i21 = Math.max(dp_i21, dp_i10 - price);
            dp_i10 = Math.max(dp_i10, dp_i11 + price);
            dp_i11 = Math.max(dp_i11, - price);
        }
        return dp_i20;
    }

    public int maxProfit1(int[] prices) {
        int[] dp_ik0 = new int[3];
        int[] dp_ik1 = new int[3];
        Arrays.fill(dp_ik1, -Integer.MAX_VALUE);
        for (int price : prices){
            for (int j=2; j>0; j--){
                dp_ik0[j] = Math.max(dp_ik0[j], dp_ik1[j] + price);
                dp_ik1[j] = Math.max(dp_ik1[j], dp_ik0[j-1] - price);
            }
        }
        return dp_ik0[2];
    }
}
