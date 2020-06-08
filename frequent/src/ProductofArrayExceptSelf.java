import java.util.Arrays;

/**
 * @author jgz
 * @Date 2020-06-04 09:56
 */
public class ProductofArrayExceptSelf {
    //使用前缀积以及后缀积
    public int[] productExceptSelf(int[] nums) {
        int[] start = new int[nums.length];
        int[] end = new int[nums.length];
        int[] res = new int[nums.length];
        int cur = 1;
        for (int i=0; i<nums.length; i++){
            cur = cur * nums[i];
            start[i] = cur;
        }

        cur = 1;
        for (int i=nums.length-1; i>=0;i--){
            cur *= nums[i];
            end[i] = cur;
        }

        for (int i=0; i<nums.length; i++){
            if (i==0){
                res[i] = end[i+1];
                continue;
            } else if (i == nums.length -1){
                res[i] = start[i-1];
                continue;
            }
            res[i] = start[i-1] * end[i+1];
        }
        return res;
    }

    //没有额外数组
    public int[] productExceptSelf1(int[] nums) {
        int[] res = new int[nums.length];
        res[0] = 1;
        for (int i=1; i<nums.length; i++){
            res[i] = res[i-1] * nums[i-1];
        }
        int R = 1;
        for (int j=nums.length-1; j>=0; j--){
            res[j] = res[j] * R;
            R = R * nums[j];
        }
        return res;
    }


}
