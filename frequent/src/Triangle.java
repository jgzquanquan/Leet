import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author jgz
 * @Date 2020-05-19 11:18
 */
public class Triangle {
    public int minimumTotal(List<List<Integer>> triangle) {
        int size = triangle.size();
        int [][] dp = new int[size][size];
        for (int i=0; i<size;i++){
            for (int j=0; j<triangle.get(i).size(); j++){
                dp[i][j] = triangle.get(i).get(j);
            }
        }

        for (int i = size - 2; i>=0; i--){
            for (int j=0; j<=i; j++){
                dp[i][j] += Math.min(dp[i+1][j], dp[i+1][j+1]);
            }
        }
        return dp[0][0];
    }

    public int minimumTotal1(List<List<Integer>> triangle) {
        int size = triangle.size();
        int [][] dp = new int[size+1][size+1];
//        多加一层则不需要初始化
//        for (int j=0; j<size; j++){
//            dp[size-1][j] = triangle.get(size-1).get(j);
//        }

        for (int i = size - 1; i>=0; i--){
            for (int j=0; j<=i; j++){
                dp[i][j] = Math.min(dp[i+1][j], dp[i+1][j+1]) + triangle.get(i).get(j);
            }
        }
        return dp[0][0];
    }

    public int minimumTotal2(List<List<Integer>> triangle) {
        int size = triangle.size();
        int [] dp = new int[size+1];

        for (int i = size - 1; i>=0; i--){
            for (int j=0; j<=i; j++){
                dp[j] = Math.min(dp[j], dp[j+1]) + triangle.get(i).get(j);
            }
        }
        return dp[0];
    }

    public static void main(String[] args) {
        Map<Short, String> map = new HashMap<>();
        for(short i = 0; i <100; i++) {
            map.put(i, String.valueOf(i));
            map.remove(i-1);
        }
        System.out.println(map.size());
    }
}
