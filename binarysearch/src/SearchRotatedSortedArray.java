/**
 * @author jgz
 * @Date 2019-11-27 22:22
 */
//33
public class SearchRotatedSortedArray {
    public int search(int[] nums, int target) {
        if (nums==null||nums.length==0){
            return -1;
        }
        int left = 0;
        int right = nums.length - 1;
        while (left<=right){
            int mid = left + ((right - left)>>1);
            if (nums[mid]==target){
                return mid;
            }else {
                if (nums[left]<=nums[mid]){
                    if (target>=nums[left] && nums[mid]>target){
                        right = mid -1;
                    }else {
                        left = mid + 1;
                    }
                }else {
                    if (target > nums[mid] && target<=nums[right]){
                        left = mid + 1;
                    }else {
                        right = mid - 1;
                    }
                }
            }
        }

        return -1;
    }
}
