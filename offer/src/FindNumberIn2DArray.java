/**
 * @author jgz
 * @Date 2020-02-26 17:00
 */
public class FindNumberIn2DArray {
    public boolean findNumberIn2DArray(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) return false;
        for (int row=0,col=matrix[0].length-1;row<matrix.length && col>=0;){
            int num = matrix[row][col];
            if (num == target) return true;
            else if (num < target) row++;
            else col--;
        }
        return false;
    }
}
