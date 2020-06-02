/**
 * @author jgz
 * @Date 2020-04-28 09:54
 */
public class SingleNumbers {
    public int[] singleNumbers(int[] nums) {
        int bitmask = 0;
        //获取不相等的两数异或值
        for (int num : nums){
            bitmask ^= num;
        }
        //获取最低位为1的那一位
        int diff = bitmask & (-bitmask);
        int[] res = new int[2];
        for (int num : nums){
            if ((num & diff) == 0){
                res[0] ^= num;
            }else {
                res[1] ^= num;
            }
        }
        return res;
    }
}
