package mogan;

import java.util.List;

/**
 * @author jgz
 * @Date 2020-04-14 15:11
 */
public class Result {

    /*
     * Complete the 'numberOfConnections' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts 2D_INTEGER_ARRAY gridOfNodes as parameter.
     */

    public static int numberOfConnections(List<List<Integer>> gridOfNodes) {
        // Write your code here
        int n = gridOfNodes.size();
        int m = gridOfNodes.get(0).size();
        int res = 0;
        int cur = 0, last = 0;
        for (int i=0; i<n; i++){
            cur = 0;
            for (int j=0; j<m; j++){
                if (gridOfNodes.get(i).get(j) == 1){
                    cur++;
                }

            }
            res += (cur * last);
            if (cur != 0){
                last = cur;
            }
        }
        return res;

    }
}
