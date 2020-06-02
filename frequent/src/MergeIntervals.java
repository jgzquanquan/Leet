import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author jgz
 * @Date 2020-04-16 09:01
 */
public class MergeIntervals {
    public int[][] merge(int[][] intervals) {
        if (intervals == null || intervals.length == 0){
            return new int[0][0];
        }
        Arrays.sort(intervals,(o1, o2) -> o1[0] - o2[0]);
        List<int[]> res = new ArrayList<>();
        for (int i=0; i<intervals.length-1; i++){
            if (intervals[i][1] >= intervals[i+1][0]){
                intervals[i+1][0] = intervals[i][0];
                intervals[i+1][1] = Math.max(intervals[i+1][1], intervals[i][1]);
            }else {
                res.add(intervals[i]);
            }
        }
        res.add(intervals[intervals.length-1]);
        return res.toArray(new int[res.size()][]);
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(new MergeIntervals().merge(new int[][]{{1,4},{4,5}})));
    }
}
