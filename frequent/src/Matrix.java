import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @author jgz
 * @Date 2020-04-15 09:42
 */
public class Matrix {
    public int[][] updateMatrix(int[][] matrix) {
        int[][] res = new int[matrix.length][matrix[0].length];
        for (int i=0; i<matrix.length; i++){
            for (int j=0; j<matrix[0].length; j++){
                if (matrix[i][j] != 0){
                    res[i][j] = find(matrix, i, j);
                }
            }
        }
        return res;
    }

    private int find(int[][] matrix, int x, int y) {
        int min = Integer.MAX_VALUE;
        for (int i=0; i<matrix.length; i++){
            for (int j=0; j<matrix[0].length; j++){
                if(x==i && y==j){
                    continue;
                }
                min = Math.min(min, Math.abs(x-i) + Math.abs(y-j));
            }
        }
        return min;
    }

    public int[][] updateMatrix1(int[][] matrix) {
        int[][] res = new int[matrix.length][matrix[0].length];
        int[][] dirs = new int[][]{{-1,0},{1,0},{0,-1},{0,1}};
        boolean[][] seen = new boolean[matrix.length][matrix[0].length];
        Queue<int[]> queue = new LinkedList<>();
        for (int i=0; i<matrix.length; i++){
            for (int j=0; j<matrix[0].length; j++){
                if (matrix[i][j] == 0){
                    queue.add(new int[]{i,j});
                    seen[i][j] = true;
                }
            }
        }

        while (!queue.isEmpty()){
            int[] cur = queue.remove();
            for (int[] dir : dirs){
                int ni = dir[0] + cur[0];
                int nj = dir[1] + cur[1];
                if (ni >= 0 && ni < matrix.length && nj >= 0 && nj < matrix[0].length && !seen[ni][nj]){
                    res[ni][nj] = 1 + res[cur[0]][cur[1]];
                    queue.add(new int[]{ni,nj});
                    seen[ni][nj] = true;
                }
            }

        }
        return res;
    }

    public int[][] updateMatrix2(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        int[][] dp = new int[m][n];
        for (int i=0; i<m; i++){
            Arrays.fill(dp[i],10001);
        }
        for (int i=0; i<m; i++){
            for (int j=0; j<n; j++){
                if (matrix[i][j] == 0){
                    dp[i][j] = 0;
                }
            }
        }

        for (int i=0; i<m; i++){
            for (int j=0; j<n; j++){
                if (i-1 >= 0){
                    dp[i][j] = Math.min(dp[i][j], dp[i-1][j]+1);
                }
                if (j-1 >= 0){
                    dp[i][j] = Math.min(dp[i][j], dp[i][j-1]+1);
                }
            }
        }

        for (int i=m-1; i>=0; i--){
            for (int j=n-1; j>=0; j--){
                if (i+1 < m){
                    dp[i][j] = Math.min(dp[i][j], dp[i+1][j]+1);
                }
                if (j+1 < n){
                    dp[i][j] = Math.min(dp[i][j], dp[i][j+1]+1);
                }
            }
        }

        return dp;
    }

}
