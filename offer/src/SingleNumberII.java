/**
 * @author jgz
 * @Date 2020-03-25 11:35
 */
public class SingleNumberII {
    public int singleNumber(int[] nums) {
        int ans = 0;
        for (int i=0; i<32; i++){
            int count = 0;
            for (int num : nums){
                if ((num & (1 << i)) != 0){
                    count++;
                }
            }
            if (count % 3 != 0) ans += 1 << i;
        }
        return ans;
    }
}
