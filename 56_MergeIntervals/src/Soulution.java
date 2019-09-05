import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class Soulution {
    public int[][] merge(int[][] intervals) {
        List<int[]> res = new ArrayList<>();
        if (intervals.length==0 || intervals == null) {
            return res.toArray(new int[0][]);
        }
        Arrays.sort(intervals,new Comparator<int[]>(){
            @Override
            public int compare(int[] a,int[] b){
                return a[0]-b[0];
            }
        });
        int i = 0;
        while (i < intervals.length){
            int left = intervals[i][0];
            int right = intervals[i][1];
            while (i < intervals.length -1 && right > intervals[i+1][0]){
                right = Math.max(right,intervals[i+1][1]);
                i++;
            }
            res.add(new int[]{left,right});
            i++;
        }
        return res.toArray(new int[0][]);
    }

    public static void main(String[] args) {
        System.out.println(new Soulution().merge(new int[][]{{1,3},{2,6},{8,10},{15,18}}));
    }

}
