/**
 * @author jgz
 * @Date 2020-03-31 09:55
 */
public class SortArray {
//    归并排序
    public int[] sortArray(int[] nums) {
        divide(nums, 0, nums.length - 1);
        return nums;
    }

    private void divide(int[] nums, int l, int r) {
        if (l>=r){
            return;
        }
        int mid = (l+r)>>1;
        divide(nums, l, mid);
        divide(nums,mid+1, r);
        merge(nums, l, mid, r);
    }

    private void merge(int[] nums, int l, int mid, int r) {
        int[] copy = new int[r-l+1];
        int q1 = mid;
        int q2 = r;
        int i = r-l;
        while (q1 >= l && q2 >= mid+1){
            if (nums[q2] > nums[q1]){
                copy[i--] = nums[q2--];
            }else {
                copy[i--] = nums[q1--];
            }
        }
        while (q1 >= l){
            copy[i--] = nums[q1--];
        }
        while (q2 >= mid+1){
            copy[i--] = nums[q2--];
        }
        for (int j=0; j<=r-l; j++){
            nums[l+j] = copy[j];
        }
    }
    
////    快速排序
//    public int[] sortArray1(int[] nums) {
//        quickSort(nums, 0, nums.length - 1);
//        return nums;
//    }
//
//    private void quickSort(int[] nums, int l, int r) {
//        if (l>=r){
//            return;
//        }
//        int lo = l + 1;
//        int hi = r;
//        while (lo<=hi){
//            if (nums[lo] > nums[l]){
//                swap(nums, lo, hi);
//                hi--;
//            }else {
//                lo++;
//            }
//        }
//        lo--;
//        swap(nums, lo, l);
//        quickSort(nums, l, lo-1);
//        quickSort(nums, lo+1, r);
//    }
//
//    private void swap(int[] nums, int i, int j) {
//        int temp = nums[i];
//        nums[i] = nums[j];
//        nums[j] = temp;
//    }


    public int[] sortArray1(int[] nums) {
        quickSort(nums, 0, nums.length - 1);
        return nums;
    }

    private void quickSort(int[] nums, int l, int r) {
        if (l >= r){
            return;
        }
        int lo = l+1;
        int hi = r;
        while (lo <= hi){
            if (nums[lo] > nums[l]){
                swap(nums, lo, hi);
                hi--;
            }else {
                lo++;
            }
        }
        lo--;
        swap(nums, lo, l);
        quickSort(nums, l, lo-1);
        quickSort(nums, lo+1, r);
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }


}
