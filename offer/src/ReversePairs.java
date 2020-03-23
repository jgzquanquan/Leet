/**
 * @author jgz
 * @Date 2020-03-23 09:40
 */
public class ReversePairs {
    private int res = 0;
//    暴力法 超出时间限制了
    public int reversePairs(int[] nums) {
        int count = 0;
        for (int i=0; i<nums.length-1; i++){
            for (int j=i+1; j<nums.length; j++){
                if (nums[j] < nums[i]){
                    count++;
                }
            }
        }
        return count;
    }

    public int reversePairs1(int[] nums) {
        if (nums == null || nums.length == 0){
            return 0;
        }
        mergeSort(nums, 0, nums.length-1);
        return res;
    }

    private void mergeSort(int[] nums, int l, int r) {
        if (l == r) return;
        int mid = (l + r) >> 1;
        mergeSort(nums, l, mid);
        mergeSort(nums, mid+1, r);
        merge(nums, l, mid, r);
    }

    private void merge(int[] nums, int l, int mid, int r) {
        int[] help = new int[r - l + 1];
        int i = r - l;
        int p1 = mid;
        int p2 = r;
        while (p1 >= l && p2 >= mid + 1){
            if (nums[p2] >= nums[p1]){
                help[i--] = nums[p2--];
            }else {
                help[i--] = nums[p1--];
                res += p2 - mid;
            }
        }
        while (p1 >= l){
            help[i--] = nums[p1--];
        }
        while (p2 >= mid+1){
            help[i--] = nums[p2--];
        }
        for (int j=0; j<=r-l; j++){
            nums[l+j] = help[j];
        }
    }
}
