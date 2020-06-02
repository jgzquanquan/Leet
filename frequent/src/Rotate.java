/**
 * @author jgz
 * @Date 2020-04-07 13:21
 */
public class Rotate {
    public void rotate(int[][] matrix) {
        int n = matrix.length;
        for (int i=0; i<n/2; i++){
            for (int j=0; j<n; j++){
                int temp = matrix[n - i - 1][j];
                matrix[n - i - 1][j] = matrix[i][j];
                matrix[i][j] = temp;
            }
        }

        for (int i=0; i<n; i++){
            for (int j=0; j<i; j++){
                int temp = matrix[j][i];
                matrix[j][i] = matrix[i][j];
                matrix[i][j] = temp;
            }
        }
    }

}
