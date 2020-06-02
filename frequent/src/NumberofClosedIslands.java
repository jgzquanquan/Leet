/**
 * @author jgz
 * @Date 2020-03-16 09:51
 */
public class NumberofClosedIslands {
    public int closedIsland(int[][] grid) {
        int ans = 0;
        for (int i=0; i<grid.length; i++){
            for (int j=0; j<grid[0].length; j++){
                if (grid[i][j] == 0 && dfs(grid, i, j)){
                    ans ++;
                }
            }
        }
        return ans;
    }

    private boolean dfs(int[][] grid, int i, int j) {
        if (i<0 || i>=grid.length || j<0 || j>=grid[0].length){
            return false;
        }
        if (grid[i][j] == 1){
            return true;
        }
        grid[i][j] = 1;

        return dfs(grid, i+1, j) & dfs(grid, i-1, j) & dfs(grid, i, j+1) & dfs(grid, i, j-1);
    }
}
