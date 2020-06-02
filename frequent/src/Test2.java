import javax.management.Query;
import javax.swing.text.MutableAttributeSet;
import java.util.*;

/**
 * @author jgz
 * @Date 2020-04-12 16:29
 */
public class Test2 {
    public int[] GetPowerFactor (int R, int N) {
        int copy = R;
        int count = 0;
        while (copy != 0){
            copy = copy / N;
            count++;
        }
        Queue<Integer> queue = new LinkedList<>();
        int sum = 0;
        for (int i=0; i<count; i++){
            sum = (int) (sum + Math.pow(N,i));
            queue.add(i);
            if (sum > R){
                sum = (int) (sum - Math.pow(N,queue.remove()));
            }
            if (sum == R)
                break;
        }
        int[] res = new int[queue.size()];
        int i = 0;
        while (!queue.isEmpty()){
            res[i++] = queue.remove();
        }
        return res;
    }

    public int[] GetPowerFactor1 (int R, int N) {
        List<Integer> list = new ArrayList<>();
        Queue<Integer> queue = new LinkedList<>();
        if (N == 1){
            int[] ans = new int[R];
            for (int i=0; i<R; i++){
                ans[i] = i;
            }
            return ans;
        }

        while (R != 0){
            if (R % N > 1)
                return new int[0];
            queue.add(R%N);
            R/=N;
        }

        int t = 0;
        while (!queue.isEmpty()){
            if (queue.peek()==1){
                list.add(t);
            }
            queue.remove();
            t++;
        }
        return list.stream().mapToInt(Integer::intValue).toArray();


    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(new Test2().GetPowerFactor1(1, 3)));
    }
}
