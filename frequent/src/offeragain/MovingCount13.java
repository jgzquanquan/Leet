package offeragain;

/**
 * @author jgz
 * @Date 2020-06-03 11:13
 */
public class MovingCount13 {
    private int cnt = 0;
    public int movingCount(int m, int n, int k) {
        if (m == 0 || n == 0){
            return cnt;
        }
        boolean[][] visted = new boolean[m+1][n+1];
        dfs(0,0,m,n,k,visted);
        return cnt;
    }

    private void dfs(int i, int j, int m, int n, int k, boolean[][] visted) {
        if (i < 0 || i >= m || j < 0|| j >= n || visted[i][j] || (i/10 + i%10 + j/10 + j%10) > k){
            return;
        }

        visted[i][j] = true;
        cnt++;
        dfs(i-1,j,m,n,k,visted);
        dfs(i+1,j,m,n,k,visted);
        dfs(i,j-1,m,n,k,visted);
        dfs(i,j+1,m,n,k,visted);
    }

    public static void main(String[] args) {
        new MovingCount13().movingCount(1,2,1);
    }
}
