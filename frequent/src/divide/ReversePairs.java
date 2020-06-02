package divide;

/**
 * @author jgz
 * @Date 2020-05-26 11:48
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
        int p = mid, q = r;
        int[] help = new int[r - l + 1];
        int k = r - l;
        while (q >= mid + 1 && p >= l){
            if (nums[q] >= nums[p]){
                help[k--] = nums[q--];
            } else {
                help[k--] = nums[p--];
                res += q - mid;
            }
        }

        while (q >= mid+1){
            help[k--] = nums[q--];
        }

        while (p >= l){
            help[k--] = nums[p--];
        }

        for (int i=0; i<help.length; i++){
            nums[i+l] = help[i];
        }
    }
}
