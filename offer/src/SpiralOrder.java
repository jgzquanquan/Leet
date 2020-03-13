import java.util.ArrayList;
import java.util.List;

/**
 * @author jgz
 * @Date 2020-03-11 11:33
 */
public class SpiralOrder {

    public int[] spiralOrder(int[][] matrix) {
        if (matrix.length == 0 ) return new int[0];
        int R = matrix.length;
        int C = matrix[0].length;
        int[] res = new int[R*C];
        boolean[][] seen = new boolean[R][C];
        int r=0, c=0, d=0;
        int[] dr = new int[]{0, 1, 0, -1};
        int[] dc = new int[]{1, 0, -1, 0};
        for (int i=0; i<R*C; i++){
            seen[r][c] = true;
            res[i] = matrix[r][c];
            int nr = r + dr[d];
            int nc = c + dc[d];
            if (nr >= 0 && nr < R && nc >= 0 && nc < C && !seen[nr][nc]){
                r = nr;
                c = nc;
            }else {
                d = (d+1)%4;
                r += dr[d];
                c += dc[d];
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[][] m = new int[][]{{1,2,3},{4,5,6},{7,8,9}};
        new SpiralOrder().spiralOrder(m);
    }
}
