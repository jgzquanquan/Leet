/**
 * @author jgz
 * @Date 2020-03-19 15:20
 */
public class MaxValue {


    public int maxValue(int[][] grid) {
        int row = grid.length;
        int col = grid[0].length;
        int[] colMax = new int[col];
        for (int i=0; i<row; i++){
            for (int j=0; j<col; j++){
                int left = 0;
                int up = 0;
                if (i > 0){
                    up = colMax[j];
                }
                if (j > 0){
                    left = colMax[j-1];
                }
                colMax[j] = Math.max(up, left) + grid[i][j];
            }
        }
        return colMax[col-1];
    }

    public int maxValue1(int[][] grid) {
        int row = grid.length;
        int col = grid[0].length;
        int[][] dp = new int[row][col];
        for (int i=0; i<row; i++){
            for (int j=0; j<col; j++){
                int up = 0;
                int left = 0;
                if (i > 0){
                    up = dp[i-1][j];
                }
                if (j > 0){
                    left = dp[i][j-1];
                }
                dp[i][j] = Math.max(up, left) + grid[i][j];
            }
        }
        return dp[row-1][col-1];
    }

}
