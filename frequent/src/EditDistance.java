/**
 * @author jgz
 * @Date 2020-04-06 17:49
 */
public class EditDistance {
    public int minDistance(String word1, String word2) {
        int len1 = word1.length();
        int len2 = word2.length();
        int[][] dp = new int[len1+1][len2+1];
        for (int i=0; i<=len1; i++){
            dp[i][0] = i;
        }

        for (int j=0; j<=len2; j++){
            dp[0][j] = j;
        }

        for (int i=1; i<=len1; i++){
            for (int j=1; j<=len2; j++){
                int left = dp[i-1][j] + 1;
                int right = dp[i][j-1] + 1;
                int down = dp[i-1][j-1];
                if (word1.charAt(i-1) != word2.charAt(j-1)){
                    down++;
                }
                dp[i][j] = Math.min(left, Math.min(right, down));
            }
        }
        return dp[len1][len2];
    }
}
