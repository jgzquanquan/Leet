import java.util.Arrays;

/**
 * @author jgz
 * @Date 2020-03-17 10:26
 */
public class GetLeastNumbers {
    public int[] getLeastNumbers(int[] arr, int k) {
        Arrays.sort(arr);
        return Arrays.copyOf(arr, k);
    }

    public int[] getLeastNumbers1(int[] arr, int k) {
        if (k == 0) return new int[k];
        int length = arr.length;
        int[] bucket = new int[10001];
        int[] out = new int[k];
        for (int num : arr){
            bucket[num]++;
        }
        a:for (int i=0,count=0; i<=length; i++){
            for (int j=0; j<bucket[i]; j++){
                out[count++] = i;
                if (count == k){
                    break a;
                }
            }
        }
        return out;
    }

    public int[] getLeastNumbers3(int []arr,int k){
        int len=arr.length;
        if (len == 0) return arr;
        if (k == len) return arr;
        if (k == 0) return new int[0];
        int re[]=new int[k];
        partition(arr,0,arr.length-1,k);
        for (int i=0;i<k;i++)
            re[i]=arr[i];
        return re;
    }

    private void partition(int[] nums, int start, int end, int k) {
        int pivot = nums[end];
        int count = start;
        for (int i=start; i<end; i++){
            if (nums[i] < pivot){
                int temp = nums[count];
                nums[count] = nums[i];
                nums[i] = temp;
                count++;
            }
        }
        int temp = nums[end];
        nums[end] = nums[count];
        nums[count] = temp;
        if (count == k-1) return;
        if (count < k-1) partition(nums, count+1, end, k);
        else partition(nums, start, count-1, k);
    }

    private void swap(int[] nums, int start, int end){
        int temp = nums[start];
        nums[start] = nums[end];
        nums[end] = temp;
    }


    public static void main(String[] args) {
        new GetLeastNumbers().getLeastNumbers1(new int[]{3,2,1}, 2);
    }
}
