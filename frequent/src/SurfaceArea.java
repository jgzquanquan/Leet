/**
 * @author jgz
 * @Date 2020-03-25 09:50
 */
public class SurfaceArea {
//    先算出每个方格有的表面积，然后减去与其左边相邻以及上边相邻的表面积
    public int surfaceArea(int[][] grid) {
        int surface = 0;
        for (int i=0; i<grid.length; i++){
            for (int j=0; j<grid[0].length; j++){
                int v = grid[i][j];
                if (v > 0){
                    surface += (v << 2) + 2;
                    surface -= i > 0 ? Math.min(v, grid[i-1][j]) << 1 : 0;
                    surface -= j > 0 ? Math.min(v, grid[i][j-1]) << 1 : 0;
                }
            }
        }
        return surface;
    }
}
