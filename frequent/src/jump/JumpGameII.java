package jump;

/**
 * @author jgz
 * @Date 2020-05-04 08:53
 */
public class JumpGameII {
    public int jump(int[] nums) {
        int rightMax = 0;
        int n = nums.length;
        int minSteps = 0;
        int end = 0;
        for (int i=0; i<n-1; i++){
            rightMax = Math.max(rightMax, i+nums[i]);
            if (i == end){
                end = rightMax;
                minSteps++;
            }
        }
        return minSteps;
    }
}
