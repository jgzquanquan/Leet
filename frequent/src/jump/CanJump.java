package jump;

/**
 * @author jgz
 * @Date 2020-05-04 08:43
 */
public class CanJump {
    // 反向
    public boolean canJump(int[] nums) {
        if (nums == null || nums.length == 0){
            return false;
        }

        int pos = nums.length - 1;
        for (int i = nums.length - 2; i>=0; i--){
            if (i + nums[i] >= pos){
                pos = i;
            }
        }
        return pos == 0;
    }
    // 正向
    public boolean canJump1(int[] nums) {
        if (nums == null || nums.length == 0){
            return false;
        }

        int n = nums.length;
        int rightMax = 0;
        for (int i = 0; i < n; i++){
            if (i <= rightMax){
                rightMax = Math.max(rightMax, i+nums[i]);
                if (rightMax >= n-1){
                    return true;
                }
            }else {
                return false;
            }
        }
        return false;
    }
}
