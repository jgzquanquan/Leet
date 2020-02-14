/**
 * 283
 * @author jgz
 * @Date 2020-02-13 17:33
 */
public class MoveZero {
    public static void moveZeroes(int[] nums) {
        int j = 0;
        for (int i=0;i<nums.length;i++){
            if (nums[i]!=0){
                nums[j] = nums[i];
                if (i!=j){
                    nums[i] = 0;
                }
                j++;
            }
        }
    }

    public static void moveZeroes1(int[] nums) {
        int j = 0;
        for (int num:nums){
            if (num!=0){
                nums[j] = num;
                j++;
            }
        }
        for (j=j+1;j<nums.length;j++){
            nums[j] = 0;
        }
    }

    public static void main(String[] args) {
        int[] nums = new int[]{0,1,0,3,12};
        moveZeroes(nums);
    }
}
