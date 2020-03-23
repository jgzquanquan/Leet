/**
 * @author jgz
 * @Date 2020-03-19 12:21
 */
public class TranslateNum {
    public int translateNum(int num) {
        char[] chars = String.valueOf(num).toCharArray();
        int[] dp = new int[chars.length + 1];
        dp[0] = 1;
        for (int i=1; i<=chars.length; i++){
            dp[i] += dp[i-1];
            if (i>1){
                int a = (chars[i-2]-'0')*10 + (chars[i-1] - '0');
                if (a>=10 && a<=25){
                    dp[i] += dp[i-2];
                }
            }
        }
        return dp[chars.length];
    }
}
