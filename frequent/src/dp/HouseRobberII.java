package dp;

/**
 * @author jgz
 * @Date 2020-05-24 11:10
 */
public class HouseRobberII {
    public int rob(int[] nums) {
        int len = nums.length;
        if (len == 0){
            return 0;
        }
        if (len == 1){
            return nums[0];
        }
        return Math.max(rob(nums,0,len-2),rob(nums,1,len-1));

    }

    private int rob(int[] nums, int l, int r) {
        int pre = 0, cur = 0, temp;
        for (int i = l; i <= r; i++){
            temp = cur;
            cur = Math.max(pre + nums[i], cur);
            pre = temp;
        }
        return cur;
    }
}
