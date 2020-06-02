import java.util.LinkedList;
import java.util.List;

/**
 * @author jgz
 * @Date 2020-03-25 15:12
 */
public class FindContinuousSequence {
    public int[][] findContinuousSequence(int target) {
        List<int[]> res = new LinkedList<>();
        int min=1,max=2,sum=3;
        while (max < target && min < max){
            if (sum < target){
                max++;
                sum += max;
            }else if (sum > target){
                sum -= min;
                min++;
            }else {
                int[] list = new int[max - min + 1];
                for (int i=min; i<=max; i++){
                    list[i-min] = i;
                }
                res.add(list);
                sum -= min;
                min++;
            }
        }
        return res.toArray(new int[0][]);
    }
}
