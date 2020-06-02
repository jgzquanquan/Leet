import java.util.ArrayDeque;
import java.util.Queue;

/**
 * @author jgz
 * @Date 2020-03-29 10:24
 */

public class AsFarfromLandasPossible {
    private class Point {
        int x;
        int y;
        int dis;
        public Point(int x, int y, int dis) {
            this.x = x;
            this.y = y;
            this.dis = dis;
        }
    }

    public int maxDistance(int[][] grid) {
        Queue<Point> queue = new ArrayDeque<>();
        int max = -1;
        boolean[][] visted = new boolean[grid.length][grid[0].length];
        for (int i=0; i<grid.length; i++){
            for (int j=0; j<grid[0].length; j++){
                if (grid[i][j] == 1){
                    queue.add(new Point(i,j,0));
                }
            }
        }
        if (queue.size() == grid.length * grid[0].length){
            return -1;
        }
        while (!queue.isEmpty()){
            Point p = queue.remove();
            if (p.x < 0 || p.x >= grid.length || p.y < 0 || p.y >= grid[0].length || visted[p.x][p.y]){
                continue;
            }
            visted[p.x][p.y] = true;
            queue.add(new Point(p.x+1, p.y, p.dis+1));
            queue.add(new Point(p.x-1, p.y, p.dis+1));
            queue.add(new Point(p.x, p.y-1, p.dis+1));
            queue.add(new Point(p.x, p.y+1, p.dis+1));
            max = Math.max(max, p.dis);
        }
        return max;
    }

    public static void main(String[] args) {
        new AsFarfromLandasPossible().maxDistance(new int[][]{{1,0,1},{0,0,0},{1,0,1}});
    }
}
