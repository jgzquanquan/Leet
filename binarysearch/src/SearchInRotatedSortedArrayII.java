/**
 * @author jgz
 * @Date 2020-03-04 17:16
 */
public class SearchInRotatedSortedArrayII {
    public boolean search(int[] nums, int target) {
        if(nums == null || nums.length == 0) return false;
        int left = 0;
        int right = nums.length - 1;
        while(left <= right){
            int mid = (left+right);
            if (nums[mid] == target) return true;
            if (nums[mid] > nums[right]){
                if (nums[left] <= target && nums[mid] > target){
                    right = mid - 1;
                }else {
                    left = mid + 1;
                }
            }else if (nums[mid] < nums[right]){
                if (nums[right] >= target && nums[mid] < target){
                    left = mid + 1;
                }else {
                    right = mid - 1;
                }
            }else {
                right--;
            }

        }
        return false;
    }
}
