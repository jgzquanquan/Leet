import java.util.HashMap;
import java.util.Map;

/**
 * @author jgz
 * @Date 2020-05-27 10:12
 */
public class SubarraySumsDivisiblebyK {
    //暴力解法 O(n^3)
    public int subarraysDivByK(int[] A, int K) {
        int count = 0;
        for (int i=0; i<A.length; i++){
            for (int j=i; j<A.length; j++){
                int sum = 0;
                for (int k=i;k<=j;k++){
                    sum += A[k];
                }
                if (sum % K == 0){
                    count++;
                }
            }
        }
        return count;
    }

    //前缀和优化
    public int subarraysDivByK1(int[] A, int K) {
        int count = 0;
        int[] sums = new int[A.length+1];
        int sum = 0;
        for (int i=1; i<=A.length; i++){
            sum += A[i-1];
            sums[i] = sum;
        }
        for (int i=0; i<A.length; i++){
            for (int j=i; j<A.length; j++){
                int res = sums[j+1] - sums[i];
                if (res % K == 0){
                    count++;
                }
            }
        }
        return count;
    }

    //使用余数作为k，value为count
    public int subarraysDivByK2(int[] nums, int K) {
        Map<Integer,Integer> map = new HashMap<>();
        map.put(0,1);
        int ans = 0;
        int sum = 0;
        for (int num : nums){
            sum += num;
            int k = (sum % K + K) % K;
            int count = map.getOrDefault(k,0);
            map.put(k,count+1);
            ans += count;
        }
        return ans;
    }

    //采用排列组合
    public int subarraysDivByK3(int[] nums, int K) {
        Map<Integer,Integer> map = new HashMap<>();
        map.put(0,1);
        int ans = 0;
        int sum = 0;
        for (int num : nums){
            sum += num;
            int k = (sum % K + K) % K;
            map.put(k,map.getOrDefault(k,0)+1);
        }

        for(int value: map.values()){
            ans += value*(value-1) / 2;
        }
        return ans;
    }
    public static void main(String[] args) {
        new SubarraySumsDivisiblebyK().subarraysDivByK2(new int[]{4,5,0,-2,-3,-1},5);
        System.out.println(-2%6);
    }
}
