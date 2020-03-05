import java.util.LinkedList;
import java.util.Queue;

/**
 * @author jgz
 * @Date 2020-03-04 10:19
 */
public class RottingOranges {

    public int orangesRotting(int[][] grid) {
        int countFresh = 0;
        Queue<int[]> queue = new LinkedList<>();
        int row = grid.length;
        int col = grid[0].length;
        for (int i=0; i<row; i++){
            for (int j=0; j<col; j++){
                if (grid[i][j] == 2){
                    queue.add(new int[]{i,j});
                }else if (grid[i][j] == 1){
                    countFresh++;
                }
            }
        }
        if (countFresh == 0) return 0;
        int count = 0;
        int[][] dirs = new int[][]{{-1,0},{1,0},{0,1},{0,-1}};
        while (!queue.isEmpty()){
            count++;
            int size = queue.size();
            for (int i=0; i<size; i++){
                int[] point = queue.remove();
                for (int[] dir : dirs){
                    int x = point[0] + dir[0];
                    int y = point[1] + dir[1];
                    if (x<0 || x>= row || y<0 || y>=col || grid[x][y] == 0 || grid[x][y] == 2) continue;
                    countFresh--;
                    grid[x][y] = 2;
                    queue.add(new int[]{x,y});
                }
            }
        }
        return countFresh == 0 ? count-1:-1;
    }
}
