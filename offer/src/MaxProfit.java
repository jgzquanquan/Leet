import org.omg.CORBA.MARSHAL;

/**
 * @author jgz
 * @Date 2020-03-30 11:08
 */
public class MaxProfit {
//    贪心解法
    public int maxProfit(int[] prices) {
        if (prices.length == 0 || prices == null){
            return 0;
        }
        int min = prices[0];
        int max = 0;
        for (int i=1; i<prices.length; i++){
            if (prices[i] < min){
                min = prices[i];
                continue;
            }
            max = Math.max(max, prices[i] - min);
        }
        return max;
    }

//    dp
    public int maxProfit1(int[] prices){
        if (prices.length == 0 || prices == null){
            return 0;
        }
        int dp_i0 = 0;
        int dp_i1 = -Integer.MAX_VALUE;
        for (int i=0; i<prices.length; i++){
            dp_i0 = Math.max(dp_i0, dp_i1 + prices[i]);
            dp_i1 = Math.max(dp_i1, -prices[i]);
        }
        return dp_i0;
    }
}
