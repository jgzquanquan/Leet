import java.util.Arrays;

/**
 * @author jgz
 * @Date 2020-02-14 15:57
 */
public class RotateArray {
// 暴力法
    public void rotate(int[] nums, int k) {
        for (int i=0;i<k;i++){
            int temp=nums[nums.length-1];
            for (int j=nums.length-1;j>0;j--){
                nums[j] = nums[j-1];
            }
            nums[0] = temp;
        }
    }

//    使用额外的数组
    public void rotate1(int[] nums, int k) {
        int[] arr = new int[nums.length];
        for (int i=0;i<nums.length;i++){
            arr[(i+k)%nums.length] = nums[i];
        }
        for (int i=0;i<nums.length;i++){
            nums[i] = arr[i];
        }
    }

//    三次翻转，第一次将整体翻转，第二次将前k个翻转，第三次将后面n-k个翻转
    public void rotate2(int[] nums, int k) {
        k = k%nums.length;
        reverse(nums,0,nums.length-1);
        reverse(nums,0,k-1);
        reverse(nums,k,nums.length-1);

    }

    private void reverse(int[] nums, int start, int end) {
        while (start<end){
            int temp = nums[start];
            nums[start++] = nums[end];
            nums[end--] = temp;
        }
    }
}
