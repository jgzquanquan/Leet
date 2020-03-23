/**
 * @author jgz
 * @Date 2020-03-23 12:12
 */
public class BinarySearch {
    public int search(int[] nums, int target) {
        int res = 0;
        if (nums != null || nums.length != 0){
            int idx1 = findFirst(nums, target);
            int idx2 = findLast(nums, target);
            if (idx1 > -1 && idx2 > -1){
                res = idx2 - idx1 + 1;
            }
        }
        return res;

    }

    private int findLast(int[] nums, int target) {
        int left = 0, right = nums.length-1;
        while (left <= right){
            int mid = (left + right) >> 1;
            if (nums[mid] > target){
                right = mid - 1;
            }else if (nums[mid] < target){
                left = mid + 1;
            }else{
                if (mid == nums.length - 1 || nums[mid + 1] != target){
                    return mid;
                }else {
                    left = mid + 1;
                }
            }
        }
        return -1;
    }

    private int findFirst(int[] nums, int target) {
        int left = 0, right = nums.length-1;
        while (left <= right){
            int mid = (left + right) >> 1;
            if (nums[mid] > target){
                right = mid - 1;
            }else if (nums[mid] < target){
                left = mid + 1;
            }else{
                if (mid == 0 || nums[mid - 1] != target){
                    return mid;
                }else {
                    right = mid - 1;
                }
            }
        }
        return -1;
    }
}
