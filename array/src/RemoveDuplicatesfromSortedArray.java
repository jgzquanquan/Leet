/**
 *26
 * 双指针法
 * @author jgz
 * @Date 2020-02-14 17:14
 */

public class RemoveDuplicatesfromSortedArray {
    public int removeDuplicates(int[] nums) {
        int i = 0;
        for (int j=1;j<nums.length;j++){
            if (nums[i]!=nums[j])
                nums[++i] = nums[j];
        }
        return i+1;
    }
}
