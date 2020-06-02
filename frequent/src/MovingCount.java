/**
 * @author jgz
 * @Date 2020-04-08 10:40
 */
public class MovingCount {
    public int movingCount(int m, int n, int k) {
        boolean[][] visited = new boolean[m][n];
        return movingCount(0, 0, m, n, k, visited);
    }

    private int movingCount(int i, int j, int m, int n, int k, boolean[][] visited) {
        if (i<0 || i>=m || j<0 || j>=n || visited[i][j] ||(i/10 + i%10 + j/10 + j%10) > k){
            return 0;
        }
        visited[i][j] = true;
        return 1 + movingCount(i+1, j, m, n, k, visited) + movingCount(i, j+1, m, n, k, visited);
    }

    public static void main(String[] args) {
        Integer a = new Integer(3);
        Integer b = 3;
        int c = 3;
        System.out.println(a == b);
        System.out.println(a == c);
    }

}
