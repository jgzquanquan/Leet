/**
 * @author jgz
 * @Date 2020-03-06 20:49
 */
public class Exchange {
    public int[] exchange(int[] nums) {
        int index = 0;
        for (int i=0; i<nums.length; i++){
            if (nums[i] % 2 == 1 ){
                if (i != index){
                    int temp = nums[index];
                    nums[index++] = nums[i];
                    nums[i] = temp;
                }else {
                    index++;
                }
            }
        }
        return nums;
    }

    public int[] exchange1(int[] nums) {
        int left = 0;
        int right = nums.length - 1;
        while (left < right){
            while (left < right && (nums[left]&1) == 1) left++;
            while (left < right && (nums[right]&1) == 0) right--;
            if (left < right){
                int temp = nums[left];
                nums[left++] = nums[right];
                nums[right--] = temp;
            }
        }
        return nums;
    }
}
