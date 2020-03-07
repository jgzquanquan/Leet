import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/**
 * @author jgz
 * @Date 2020-03-06 09:12
 */
public class FindContinuousSequence {
//暴力法
    public int[][] findContinuousSequence(int target) {
        if (target <= 2) return null;
        List<int[]> res = new LinkedList<>();
        int sum = 0;
        for (int i=1; i<=(target-1)/2;i++){
            for (int j=i; ;j++){
                sum += j;
                if (sum > target){
                    sum = 0;
                    break;
                }else if (sum == target){
                    int[] list = new int[j-i+1];
                    for (int k=i; k<=j; k++){
                        list[k-i] = k;
                    }
                    res.add(list);
                }
            }
        }
        return res.toArray(new int[0][]);
    }
//    双指针
    public int[][] findContinuousSequence1(int target) {
        if (target <= 2) return null;
        List<int[]> res = new LinkedList<>();
        for (int min=1,max=2; min<max;){
            int sum = (min + max) * (max - min + 1) / 2;
            if (sum < target){
                max++;
            }else if (sum > target){
                min++;
            }else {
                int[] list = new int[max - min +1];
                for (int k=min; k<=max; k++){
                    list[k-min] = k;
                }
                res.add(list);
                min++;
            }
        }
        return res.toArray(new int[0][]);
    }

    public int[][] findContinuousSequence2(int target) {
        List<int[]> res = new ArrayList<>();
        int left = 1;
        int right = 2;
        while(left < right){
            int num = (left + right) * (right - left + 1) / 2;
            if(num > target){
                left++;
            }else if(num < target){
                right++;
            }else{
                int[]list = new int[right-left+1];
                for(int i=left; i<=right; i++){
                    list[i-left] = i;
                }
                res.add(list);
                left++;
            }
        }
        return res.toArray(new int[0][]);
    }

    public static void main(String[] args) {
        new FindContinuousSequence().findContinuousSequence2(9);
    }
}
