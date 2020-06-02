/**
 * @author jgz
 * @Date 2020-05-06 09:09
 */
public class MinimumCostForTickets {
    public int mincostTickets(int[] days, int[] costs) {
        int len = days.length;
        int minDay = days[0], maxDay = days[len - 1];
        int[] dp = new int[maxDay + 31];

        for (int d = maxDay, i=len-1; d >= minDay; d--){
            if (d == days[i]){
                dp[d] = Math.min(dp[d+1] + costs[0], dp[d+7] + costs[1]);
                dp[d] = Math.min(dp[d], dp[d+30] + costs[2]);
                i--;
            }else {
                dp[d] = dp[d+1];
            }
        }
        return dp[minDay];
    }
}
