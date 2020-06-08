package offeragain;

import java.util.ArrayList;
import java.util.List;

/**
 * @author jgz
 * @Date 2020-06-02 09:51
 */
public class FindRepeatNumber03 {
    // O(N) O()
    public int findRepeatNumber(int[] nums) {
        int[] count = new int[nums.length];
        for (int num : nums){
            if (count[num] > 0){
                return num;
            }
            count[num]++;
        }
        return -1;
    }

    //由于数组元素的值都在指定的范围内，这个范围恰恰好与数组的下标可以一一对应；可以达到O(1)空间复杂度
    public int findRepeatNumber1(int[] nums) {
        int temp;
        for (int i = 0; i < nums.length; ){
            if (i == nums[i]){
                i++;
                continue;
            }
            if (nums[i] == nums[nums[i]]){
                return nums[i];
            }
            //交换
            temp = nums[i];
            nums[i] = nums[temp];
            nums[temp] = temp;
        }
        return -1;
    }

}

//Leetcode 442  你可以不用到任何额外空间并在O(n)时间复杂度内解决这个问题
class FindAllDuplicatesinanArray{
    public List<Integer> findDuplicates(int[] nums) {
        List<Integer> res = new ArrayList<>();

        for (int i = 0; i < nums.length; i++){
            int index = Math.abs(nums[i]) - 1;
            //注意这里是循环，这样能够一直交换把该位置交换对
            if (nums[index] < 0){
                res.add(index+1);
                continue;
            }
            nums[index] = -nums[index];
        }
        return res;
    }

    public List<Integer> findDuplicates1(int[] nums) {
        List<Integer> res = new ArrayList<>();

        int temp;
        for (int i = 0; i < nums.length; ){
            if (i == nums[i]-1){
                i++;
                continue;
            }
            if (nums[i] == nums[nums[i]-1]){
                res.add(nums[i]);
            }
            //交换
            temp = nums[i]-1;
            nums[i] = nums[temp];
            nums[temp] = temp+1;
        }
        return res;
    }

    public static void main(String[] args) {
        new FindAllDuplicatesinanArray().findDuplicates1(new int[]{4,3,2,7,8,2,3,1});
    }
}
