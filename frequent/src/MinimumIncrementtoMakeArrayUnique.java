import java.util.Arrays;

/**
 * @author jgz
 * @Date 2020-03-22 12:00
 */
public class MinimumIncrementtoMakeArrayUnique {
    public int minIncrementForUnique(int[] A) {
       int[] count = new int[80000];
       for (int num : A){
           count[num]++;
       }
       int ans = 0;
       int taken = 0;
       for (int i=0; i<80000; i++){
           if (count[i] >= 2){
               taken += (count[i]-1);
               ans -= (i*(count[i] - 1));
           }else if (taken > 0 && count[i] == 0){
               taken--;
               ans += i;
           }
       }
       return ans;
    }

    public int minIncrementForUnique1(int[] A) {
        Arrays.sort(A);
        int res = 0, need = 0;
        for (int a : A) {
            res += Math.max(need - a, 0);
            need = Math.max(a, need) + 1;
        }
        return res;
    }

    public static void main(String[] args) {
        new MinimumIncrementtoMakeArrayUnique().minIncrementForUnique1(new int[]{1,2,2});
    }
}
