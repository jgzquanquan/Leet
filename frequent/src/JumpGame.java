/**
 * @author jgz
 * @Date 2020-04-17 08:03
 */
public class JumpGame {

    //最后一个样例超时了
    public boolean canJump(int[] nums) {
        return canJump(nums, 0);
    }

    private boolean canJump(int[] nums, int x) {
        if (x + nums[x] >= nums.length - 1) {
            return true;
        }

        for (int i = nums[x]; i >= 0; i--) {
            boolean flag = canJump(nums, x + i);
            if (flag) {
                return true;
            }
        }

        return false;
    }

    //贪心解法
    public boolean canJump1(int[] nums) {
        int n = nums.length;
        int rightMax = 0;
        for (int i = 0; i < n; i++) {
            if (i <= rightMax) {
                rightMax = Math.max(rightMax, i + nums[i]);
                if (rightMax >= n - 1) {
                    return true;
                }
            } else {
                return false;
            }
        }
        return false;
    }

    //倒着推
    public boolean canJump2(int[] nums) {
        if (nums == null || nums.length == 0) {
            return false;
        }
        int pos = nums.length - 1;
        for (int i = nums.length - 2; i >= 0; i--) {
            if (nums[i] + i >= pos) {
                pos = i;
            }
        }
        return pos == 0;
    }
}
