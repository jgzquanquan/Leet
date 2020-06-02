import java.util.Arrays;

/**
 * @author jgz
 * @Date 2020-03-27 11:25
 */
public class IsStraight {
    public boolean isStraight(int[] nums) {
        Arrays.sort(nums);
        int count = 0;
        if (nums[0] == 0) count++;
        for (int i=1; i<5; i++){
            if (nums[i] == 0){
                count++;
                continue;
            }
            if (nums[i] == nums[i-1]){
                return false;
            }

            if (nums[i-1] != 0 && nums[i] - nums[i-1] > 1){
                count -= (nums[i] - nums[i-1] - 1);
            }
        }
        return count >= 0;
    }

    public static void main(String[] args) {
        new IsStraight().isStraight(new int[]{0,0,1,2,5});
    }

}
