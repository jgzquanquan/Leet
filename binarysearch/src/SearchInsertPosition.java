/**
 * @author jgz
 * @Date 2019-11-26 21:18
 */

//35
//    可以转化成查找第一个大于等于某数的问题
public class SearchInsertPosition {
    public int searchInsert(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        while (left<=right){
            int mid = (right+left)>>>1;
            if (nums[mid]>=target){
                if(mid==0 || nums[mid-1] < target){
                    return mid;
                }else {
                    right = mid-1;
                }
            }else {
                left = mid+1;
            }
        }
        return left;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1,3,5,6};
        System.out.println(new SearchInsertPosition().searchInsert(nums,2));
    }
}
