/**
 * @author jgz
 * @Date 2020-05-08 09:19
 */
public class MaximalSquare {
    public int maximalSquare(char[][] matrix) {
        int maxSlide = 0;
        if (matrix == null || matrix.length == 0){
            return maxSlide;
        }
        int[][] dp = new int[matrix.length][matrix[0].length];
        for (int i = 0; i < matrix.length; i++){
            for (int j = 0; j < matrix[0].length; j++){
                if (matrix[i][j] == '1'){
                    if (i == 0 || j == 0){
                        dp[i][j] = 1;
                    } else {
                        dp[i][j] = Math.min(Math.min(dp[i-1][j-1], dp[i][j-1]), dp[i-1][j]) + 1;
                    }
                    maxSlide = Math.max(maxSlide, dp[i][j]);
                }
            }
        }
        return maxSlide * maxSlide;
    }
}
