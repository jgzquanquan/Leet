/**
 * @author jgz
 * @Date 2020-03-03 18:20
 */
public class MovingCount {

    public int movingCount(int m, int n, int k) {
        boolean[][] visted = new boolean[m][n];
        return dfs(0,0, m, n, k,visted);
    }

    private int dfs(int i, int j, int m, int n, int k, boolean[][] visted) {
        if (i<0 || i>=m || j<0 || j>=n || visted[i][j] || (i/10+i%10+j/10+j%10)>k){
            return 0;
        }
        visted[i][j] = true;
        return 1+dfs(i+1, j, m, n, k, visted) + dfs(i, j+1, m, n, k, visted);
    }

}
