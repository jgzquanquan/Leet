/**
 * @author jgz
 * @Date 2020-04-24 09:39
 */
public class ReversePairs {
    private int res = 0;
    public int reversePairs(int[] nums) {
        if (nums == null || nums.length == 0){
            return res;
        }
        mergeSort(nums, 0, nums.length-1);
        return res;
    }

    private void mergeSort(int[] nums, int l, int r) {
        if (l >= r){
            return;
        }
        int mid = (l+r) >> 1;
        mergeSort(nums, l, mid);
        mergeSort(nums, mid+1, r);
        merge(nums, l, mid, r);
    }

    private void merge(int[] nums, int l, int mid, int r) {
        int[] help = new int[l-r+1];
        int p1 = mid;
        int p2 = r;
        int i = r-l;
        while (p1 >= l && p2 >= mid+1){
            if (nums[p2] >= nums[p1]){
                help[i--] = nums[p2--];
            }else {
                res += p2 - mid;
                help[i--] = nums[p1--];
            }
        }

        while (p1 >= 0){
            help[i--] = nums[p1--];
        }

        while (p2 >= mid+1){
            help[i--] = nums[p2--];
        }
        for (int j=0; j<help.length; j++){
            nums[l+j] = help[j];
        }
    }
}
