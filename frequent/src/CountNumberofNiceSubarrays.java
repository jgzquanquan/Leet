/**
 * @author jgz
 * @Date 2020-04-21 10:24
 */
public class CountNumberofNiceSubarrays {
    public int numberOfSubarrays(int[] nums, int k) {
        int ans = 0, cnt = 0;
        int[] odd = new int[nums.length + 2];
        for (int i=0; i<nums.length; i++){
            if ((nums[i] & 1) == 1){
                //这样方便第一位是0
                odd[++cnt] = i;
            }
        }
        // 注意首末两位的取值
        odd[0] = -1;
        odd[++cnt] = nums.length;
        for (int i=1; i+k <= cnt; i++){
            ans += (odd[i] - odd[i-1]) * (odd[i+k] - odd[i+k-1]);
        }
        return ans;
    }
}
